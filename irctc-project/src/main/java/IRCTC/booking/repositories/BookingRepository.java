package IRCTC.booking.repositories;

import IRCTC.booking.collection.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking,String> {


}
