package in.stackroute.batchservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.batchservice.domain.Batch;
import in.stackroute.batchservice.domain.Mentor;
import in.stackroute.batchservice.domain.Student;
import in.stackroute.batchservice.dto.BatchDto;
import in.stackroute.batchservice.service.BatchService;
import in.stackroute.batchservice.service.MentorService;
import in.stackroute.batchservice.service.StudentService;

@RestController
@RequestMapping("/api/v1/batches")
public class BatchController {

    private BatchService batchService;
    private StudentService studentService;
    private MentorService mentorService;

    public BatchController(BatchService batchService, StudentService studentService,
            MentorService mentorService) {
        this.batchService = batchService;
        this.studentService = studentService;
        this.mentorService = mentorService;
    }

    // get all batches
    @GetMapping({"", "/"})
    public ResponseEntity<List<Batch>> getAll() {
        if (batchService.getAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(batchService.getAll());
    }

    // get batch by id
    @GetMapping("/{id}")
    public ResponseEntity<Batch> getById(@PathVariable String id) {
        Optional<Batch> batch = batchService.getById(id);
        if (!batch.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(batch.get());
    }

    // post create batch
    @PostMapping({"", "/"})
    public ResponseEntity<Batch> create(@RequestBody BatchDto batchDto) {
        List<String> students = batchDto.getStudents();
        if(students == null || students.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Student> learners =  studentService.getAllbyIds(students);
        if(learners.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Mentor mentor = mentorService.getById(batchDto.getMentor());
        if(mentor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Batch batch = new Batch(batchDto, learners, mentor);
        return ResponseEntity.status(HttpStatus.CREATED).body(batchService.create(batch));
    }

}
