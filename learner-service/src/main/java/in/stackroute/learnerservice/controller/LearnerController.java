package in.stackroute.learnerservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.learnerservice.domain.Learner;
import in.stackroute.learnerservice.service.LearnerService;

@RestController
@RequestMapping("/api/v1/learners")
@CrossOrigin(origins = "*")
public class LearnerController {

    private LearnerService learnerService;

    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }


    // save the learner
    @PostMapping({"","/"})
    public ResponseEntity<Learner> saveLearner(@RequestBody Learner learner) {
        Learner savedLearner = learnerService.save(learner);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLearner);
    }
    
    // get the learner by id
    @GetMapping({"/{id}"})
    public ResponseEntity<Learner> getLearnerById(@PathVariable String id) {

        Optional<Learner> learner = learnerService.getById(id);
        if(learner.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(learner.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Learner>> getAllLearners() {
        List<Learner> learnerList = learnerService.getAll();
        if(learnerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(learnerList);
    }

    // update the learner
    @PutMapping({"/{id}"})
    public ResponseEntity<Learner> updateLearner(@RequestBody Learner newLearnerData, @PathVariable String id) {
        Optional<Learner> existingLearnerOpt = learnerService.getById(id);
        if(existingLearnerOpt.isPresent()){
            Learner existingLeaner =  existingLearnerOpt.get();
            existingLeaner.setName(newLearnerData.getName());
            existingLeaner.setEmail(newLearnerData.getEmail());
            existingLeaner.setAddress(newLearnerData.getAddress());
            existingLeaner.setPhoneNumber(newLearnerData.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(learnerService.update(existingLeaner));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // delete the learner
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Learner> deleteLearner(@PathVariable String id) {
        learnerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // get id list
    @GetMapping({"/ids/{ids}"})
    public ResponseEntity<List<Learner>> getIds(@PathVariable List<String> ids) {
        System.err.println(ids);
        ids.forEach(String::trim);
        List<Learner> learners = learnerService.getByIds(ids);
        if(learners.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(learners);
    }
    
}
