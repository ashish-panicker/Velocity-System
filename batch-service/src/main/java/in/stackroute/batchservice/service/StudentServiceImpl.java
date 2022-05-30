package in.stackroute.batchservice.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.stackroute.batchservice.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private RestTemplate restTemplate;

    public StudentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Student> getAllbyIds(List<String> ids) {
        String data = ids.toString().replaceAll("[\\[\\](){}]","");
        Student[] body = restTemplate.getForEntity("http://localhost:8000/api/v1/learners/ids/{ids}",Student[].class, data).getBody();
        return Arrays.asList(body);
    }
}
