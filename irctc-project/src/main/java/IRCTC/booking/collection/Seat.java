package IRCTC.booking.collection;

import IRCTC.booking.enums.SeatStatus;
import IRCTC.booking.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("seats")
public class Seat {

    Integer seatNumber;

    SeatType seatType;

    SeatStatus status;

}
