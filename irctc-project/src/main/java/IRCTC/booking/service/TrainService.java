package IRCTC.booking.service;

import IRCTC.booking.collection.Train;
import IRCTC.booking.collection.User;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.repositories.TrainRepository;
import IRCTC.booking.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    Logger logger = LoggerFactory.getLogger(TrainService.class);

    TrainRepository trainRepository;
    public TrainService(TrainRepository trainRepository)
    {
        this.trainRepository=trainRepository;
    }

    public Train createNewTrain(Train train) throws TicketingCustomException {

        try {
            return trainRepository.save(train);

        } catch (Exception e) {

            logger.error(">>>> Error in creating train : {}", e.getMessage());
            throw new TicketingCustomException("Error in creating train: "+e.getMessage());

        }
    }

    public Train getTrain(String trainNo) throws TicketingCustomException {

        return trainRepository.findByTrainNumber(trainNo)
                .orElseThrow(() -> new TicketingCustomException("No Train found against the input Train detail"));

    }

    public List<Train> getAllTrains() {

        return trainRepository.findAll();
    }

    public void deleteTrain(Train train) {

        trainRepository.delete(train);
    }

    public Train updatetrain(Train train) throws TicketingCustomException {

        Train savedTrain = trainRepository.findByTrainNumber(train.getTrainNumber())
                .orElseThrow(() -> new TicketingCustomException("No Train found against the input Train detail"));

        if (train.getTrainName() != null) {
            savedTrain.setTrainName(train.getTrainName());

        } else if (train.getAvailableSeats() != null) {
            savedTrain.setAvailableSeats(train.getAvailableSeats());

        } else if (train.getOriginCode() != null) {
            savedTrain.setOriginStation(train.getOriginCode());

        } else if (train.getDestinationStation() != null) {
            savedTrain.setDestinationStation(train.getDestinationStation());

        } else if (train.getTotalSeats() != null) {
            savedTrain.setTotalSeats(train.getTotalSeats());

        } else if (train.getTravelTime()!=null) {

            savedTrain.setTravelTime(train.getTravelTime());
        }
        return trainRepository.save(savedTrain);

    }


}
