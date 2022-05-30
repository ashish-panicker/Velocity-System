package in.stackroute.mentorservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.mentorservice.domain.Mentor;
import in.stackroute.mentorservice.service.MentorService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/mentors")
public class MentorController {

    private MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> allMentors = mentorService.getAll();
        if (allMentors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allMentors);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Mentor> getMentorById(@PathVariable String id) {
        Optional<Mentor> mentor = mentorService.getById(id);
        if (!mentor.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mentor.get());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Mentor> postCreateMentor(@RequestBody Mentor entity) {
        Mentor mentor = mentorService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentor);
    }

}

