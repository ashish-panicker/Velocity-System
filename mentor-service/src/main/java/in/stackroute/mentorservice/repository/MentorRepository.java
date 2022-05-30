package in.stackroute.mentorservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import in.stackroute.mentorservice.domain.Mentor;

public interface MentorRepository extends MongoRepository<Mentor, String> {

}
