package in.stackroute.batchservice.service;

import java.util.List;
import in.stackroute.batchservice.domain.Student;

public interface StudentService {
    
    public List<Student> getAllbyIds(List<String> ids);
    
    
}
