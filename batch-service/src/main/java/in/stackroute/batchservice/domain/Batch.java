package in.stackroute.batchservice.domain;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import in.stackroute.batchservice.dto.BatchDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "batches")
public class Batch {

    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String code;

    private String description;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    private Status status;
    
    List<Student> students;

    public Batch(BatchDto batchDto, List<Student> students) {
        this.code = batchDto.getCode();
        this.description = batchDto.getDescription();
        this.startDate = batchDto.getStartDate();
        this.endDate = batchDto.getEndDate();
        this.status = batchDto.getStatus();
        this.students = students;
    }
}
