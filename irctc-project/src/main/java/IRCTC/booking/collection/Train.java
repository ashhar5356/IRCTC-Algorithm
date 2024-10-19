package IRCTC.booking.collection;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("trains")
public class Train {

    @Id
    String id;

    String trainName;

    @NotBlank(message = "train number cannot be null/blank")
    String trainNumber;

    String originStation;

    String destinationStation;

    String originCode;

    String destinationCode;

    Integer totalSeats;

    Integer availableSeats;

    Integer travelTime;

    @DBRef
    List<Booking> bookingList;
}
