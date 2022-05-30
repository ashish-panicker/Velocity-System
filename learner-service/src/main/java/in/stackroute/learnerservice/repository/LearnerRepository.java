package in.stackroute.learnerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import in.stackroute.learnerservice.domain.Learner;

public interface LearnerRepository extends MongoRepository<Learner, String> {
    
}
