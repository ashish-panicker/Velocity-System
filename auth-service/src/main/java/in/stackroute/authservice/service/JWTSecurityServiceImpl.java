package in.stackroute.authservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import in.stackroute.authservice.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTSecurityServiceImpl implements SecurityService {

    @Override
    public Map<String, String> getAuthToken(User user) {
        String token = null;
        token = Jwts.builder().setSubject(user.getUserName()).claim("userId", user.getId())
                .claim("role", user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("message", "token generated");
        tokenMap.put("token", token);
        tokenMap.put("status", HttpStatus.OK.toString());
        return tokenMap;
    }

    @Override
    public boolean validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
        if (claims != null) {
            return true;
        }
        return false;

    }

}
