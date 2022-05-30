package in.stackroute.batchservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.batchservice.domain.Batch;
import in.stackroute.batchservice.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {

    private BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Batch create(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Optional<Batch> getById(String id) {
        return batchRepository.findById(id);
    }

    @Override
    public Batch update(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public void delete(String id) {
        batchRepository.deleteById(id);
    }

    @Override
    public List<Batch> getAll() {
        return batchRepository.findAll();
    }


}
