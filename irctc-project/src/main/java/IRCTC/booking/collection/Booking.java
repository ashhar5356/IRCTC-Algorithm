package IRCTC.booking.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("bookings")
public class Booking {

    @Id
    String bookingId;
    LocalDateTime bookingDate;

    String bookingFrom;

    String bookingTo;

    Passenger passengerAgainstBooking;

    Train trainAgainstBooking;

    Seat seatAgainstBooking;

    String bookingStatus;


}
