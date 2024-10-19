package IRCTC.booking.repositories;

import IRCTC.booking.collection.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat,String> {
}
