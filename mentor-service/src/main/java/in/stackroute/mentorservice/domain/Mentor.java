package in.stackroute.mentorservice.domain;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mentors")
public class Mentor {

    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String name;

    private String email;

    private String address;

    private String phoneNumber;

    private List<String> technologies;
}
