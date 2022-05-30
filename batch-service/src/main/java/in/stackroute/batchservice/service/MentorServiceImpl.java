package in.stackroute.batchservice.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.stackroute.batchservice.domain.Mentor;

@Service
public class MentorServiceImpl implements MentorService {

    private RestTemplate restTemplate;

    public MentorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Mentor getById(String id) {
        ResponseEntity<Mentor> response = restTemplate.getForEntity("http://localhost:8200/api/v1/mentors/{id}", Mentor.class, id);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

    
}
