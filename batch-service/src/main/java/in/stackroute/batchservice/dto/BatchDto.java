package in.stackroute.batchservice.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import in.stackroute.batchservice.domain.Mentor;
import in.stackroute.batchservice.domain.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {

    private String code;

    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    private Status status;

    private List<String> students;

    private String mentor;
    
}
