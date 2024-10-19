package IRCTC.booking.repositories;

import IRCTC.booking.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByUserName(String userName);

}
