package in.stackroute.batchservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import in.stackroute.batchservice.domain.Batch;

public interface BatchRepository extends MongoRepository<Batch, String>{
    
}
