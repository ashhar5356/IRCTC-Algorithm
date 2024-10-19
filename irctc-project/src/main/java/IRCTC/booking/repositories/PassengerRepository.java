package IRCTC.booking.repositories;

import IRCTC.booking.collection.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger,String> {

}
