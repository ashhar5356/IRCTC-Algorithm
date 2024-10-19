package IRCTC.booking.service;

import IRCTC.booking.collection.User;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User createNewUser(User user) throws TicketingCustomException {

        try {
            return userRepository.save(user);

        } catch (Exception e) {

            logger.error(">>>> Error in creating user : {}", e.getMessage());
            throw new TicketingCustomException("Error in creating user: "+e.getMessage());

        }
    }

    public User getUser(String userName) throws TicketingCustomException {

        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new TicketingCustomException("No user found against the input user detail"));

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public void deleteUser(User user) {

        userRepository.delete(user);
    }

    public User updateUser(User user) throws TicketingCustomException {

        User savedUser = userRepository.findByUserName(user.getUserName())
                .orElseThrow(() -> new TicketingCustomException("No user found against the input user detail"));

        if (user.getAge() != null) {
            savedUser.setAge(user.getAge());

        } else if (user.getPassword() != null) {
            savedUser.setPassword(user.getPassword());

        } else if (user.getEmail() != null) {
            savedUser.setEmail(user.getEmail());

        } else if (user.getGender() != null) {
            savedUser.setGender(user.getGender());

        } else if (user.getName() != null) {
            savedUser.setName(user.getName());

        }
        return userRepository.save(savedUser);

    }

}
