package IRCTC.booking.controller;

import IRCTC.booking.collection.User;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<User> getOne(@PathVariable String userName) throws TicketingCustomException {
        return new ResponseEntity<>(userService.getUser(userName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() throws TicketingCustomException {


        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<User> create(@Validated @RequestBody User user) throws TicketingCustomException {
        return new ResponseEntity<>(userService.createNewUser(user), HttpStatus.ACCEPTED);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody User user) throws TicketingCustomException {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user) {
        userService.deleteUser(user);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }


}
