package in.stackroute.mentorservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.mentorservice.domain.Mentor;

public interface MentorService {
    
    public Optional<Mentor> getById(String id);
    
    public Mentor create(Mentor mentor);
    
    public Mentor update(Mentor mentor);
    
    public void delete(String id);
    
    public List<Mentor> getAll();
    
}
