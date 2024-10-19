package IRCTC.booking.repositories;

import IRCTC.booking.collection.Train;
import IRCTC.booking.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TrainRepository extends MongoRepository<Train,String> {

    Optional<Train> findByTrainNumber(String trainNumber);

}
