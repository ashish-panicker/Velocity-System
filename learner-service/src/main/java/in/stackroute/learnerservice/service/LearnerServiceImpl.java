package in.stackroute.learnerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.learnerservice.domain.Learner;
import in.stackroute.learnerservice.repository.LearnerRepository;

@Service
public class LearnerServiceImpl implements LearnerService {

    private LearnerRepository learnerRepository;

    public LearnerServiceImpl(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    @Override
    public Learner save(Learner learner) {
        return learnerRepository.save(learner);
    }

    @Override
    public Optional<Learner> getById(String id) {
        return learnerRepository.findById(id);
    }

    @Override
    public Learner update(Learner learner) {
        return learnerRepository.save(learner);
    }

    @Override
    public void delete(String id) {
        learnerRepository.deleteById(id);
    }

    @Override
    public List<Learner> getAll() {
        return learnerRepository.findAll();
    }

    @Override
    public List<Learner> getByIds(List<String> ids) {
        List<Learner> learners = new ArrayList<>();
        learnerRepository.findAllById(ids).forEach(learners::add);
        return learners;
    }

}
