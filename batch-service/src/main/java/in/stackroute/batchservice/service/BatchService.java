package in.stackroute.batchservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.batchservice.domain.Batch;

public interface BatchService {
    
    public Batch create(Batch batch);
    
    public Optional<Batch> getById(String id);
    
    public Batch update(Batch batch);
    
    public void delete(String id);
    
    public List<Batch> getAll();
    
}
