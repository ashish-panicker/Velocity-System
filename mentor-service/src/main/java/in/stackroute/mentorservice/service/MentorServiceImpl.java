package in.stackroute.mentorservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.mentorservice.domain.Mentor;
import in.stackroute.mentorservice.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService{

    private MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Optional<Mentor> getById(String id) {
        return mentorRepository.findById(id);
    }

    @Override
    public Mentor create(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentor update(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public void delete(String id) {
        getById(id).ifPresent(mentor -> mentorRepository.delete(mentor));
    }

    @Override
    public List<Mentor> getAll() {
        return mentorRepository.findAll();
    }
    
}
