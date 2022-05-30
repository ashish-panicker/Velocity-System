package in.stackroute.authservice.service;

import java.util.Map;
import in.stackroute.authservice.domain.User;

public interface SecurityService {

    Map<String, String> getAuthToken(User user);

    boolean validateToken(String token);
    
}
