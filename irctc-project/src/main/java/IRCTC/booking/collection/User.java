package IRCTC.booking.collection;

import IRCTC.booking.enums.Roles;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("users")
@Builder
public class User {

    @Id
    String id;


    @NotBlank(message = "username annot be null/blank")
    String userName;


    String password;

    @Indexed
    String name;

    Integer age;

    String gender;

    List<Roles> roles;

    String email;

    @DBRef
    List<Passenger> passengerList;

}
