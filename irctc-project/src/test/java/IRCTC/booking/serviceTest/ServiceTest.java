package IRCTC.booking.serviceTest;

import IRCTC.booking.collection.Train;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.service.TrainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceTest {

    @Autowired
    TrainService trainService;

    @Test
    public void testTrainService1() throws TicketingCustomException {

        assertEquals(4,2+2);
        assertNotNull(trainService.createNewTrain(new Train()));

    }

    @Test
    @Disabled
    public void testTrainService2() throws TicketingCustomException {

        assertNotNull(trainService.getTrain("123"));

    }

    @ParameterizedTest
    @CsvSource({
        "1,1,2", "2,2,4"

    })
    public void parameterizedTest(int a, int b, int result)
    {
        assertEquals(result,a,b);
    }




}
