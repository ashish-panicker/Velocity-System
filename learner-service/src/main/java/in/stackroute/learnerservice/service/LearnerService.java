package in.stackroute.learnerservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.learnerservice.domain.Learner;

public interface LearnerService {
    
        public Learner save(Learner learner);
    
        public Optional<Learner> getById(String id);

        public List<Learner> getByIds(List<String> ids );
    
        public Learner update(Learner learner);
    
        public void delete(String id);

        public List<Learner> getAll();
    
}
