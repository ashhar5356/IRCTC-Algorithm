//package IRCTC.booking.service;
//
//import IRCTC.booking.collection.Booking;
//import IRCTC.booking.collection.Train;
//import IRCTC.booking.customexceptions.TicketingCustomException;
//import IRCTC.booking.repositories.BookingRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import java.awt.print.Book;
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    Logger logger = LoggerFactory.getLogger(BookingService.class);
//
//    BookingRepository bookingRepository;
//    public BookingService(BookingRepository bookingRepository)
//    {
//        this.bookingRepository=bookingRepository;
//    }
//
//    public Booking createNewBooking(Booking booking) throws TicketingCustomException {
//
//        try {
//            return bookingRepository.save(booking);
//
//        } catch (Exception e) {
//
//            logger.error(">>>> Error in creating booking : {}", e.getMessage());
//            throw new TicketingCustomException("Error in creating booking: "+e.getMessage());
//
//        }
//    }
//
//    public Booking getBooking(String bookingId) throws TicketingCustomException {
//
//        return bookingRepository.findByTrainNumber(trainNo)
//                .orElseThrow(() -> new TicketingCustomException("No Train found against the input Train detail"));
//
//    }
//
//    public List<Train> getAllTrains() {
//
//        return trainRepository.findAll();
//    }
//
//    public void deleteTrain(Train train) {
//
//        trainRepository.delete(train);
//    }
//
//    public Train updatetrain(Train train) throws TicketingCustomException {
//
//        Train savedTrain = trainRepository.findByTrainNumber(train.getTrainNumber())
//                .orElseThrow(() -> new TicketingCustomException("No Train found against the input Train detail"));
//
//        if (train.getTrainName() != null) {
//            savedTrain.setTrainName(train.getTrainName());
//
//        } else if (train.getAvailableSeats() != null) {
//            savedTrain.setAvailableSeats(train.getAvailableSeats());
//
//        } else if (train.getOriginCode() != null) {
//            savedTrain.setOriginStation(train.getOriginCode());
//
//        } else if (train.getDestinationStation() != null) {
//            savedTrain.setDestinationStation(train.getDestinationStation());
//
//        } else if (train.getTotalSeats() != null) {
//            savedTrain.setTotalSeats(train.getTotalSeats());
//
//        } else if (train.getTravelTime()!=null) {
//
//            savedTrain.setTravelTime(train.getTravelTime());
//        }
//        return trainRepository.save(savedTrain);
//
//    }
//
//
//
//}
