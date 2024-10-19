package IRCTC.booking.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("passengers")
public class Passenger {

    @Id
    String id;

    String name;

    Integer age;

    Integer gender;

    String phoneNumber;

    String originStation;

    String destinationAddress;

    User user;

    Train train;

    Seat seat;

}
