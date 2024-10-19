package IRCTC.booking.controller;

import IRCTC.booking.collection.Train;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    TrainService trainService;


    @GetMapping("/{trainNo}")
    public ResponseEntity<Train> getOne(@PathVariable String trainNo) throws TicketingCustomException {
        return new ResponseEntity<>(trainService.getTrain(trainNo), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllBookings() throws TicketingCustomException {
        return new ResponseEntity<>(trainService.getAllTrains(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Train> create(@Validated @RequestBody Train train) throws TicketingCustomException {
        return new ResponseEntity<>(trainService.createNewTrain(train), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Train> cancel(@Validated @RequestBody Train train) throws TicketingCustomException {
        return new ResponseEntity<>(trainService.createNewTrain(train), HttpStatus.ACCEPTED);
    }





}
