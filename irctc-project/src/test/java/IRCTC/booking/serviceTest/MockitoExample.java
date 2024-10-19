package IRCTC.booking.serviceTest;


import IRCTC.booking.collection.User;
import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.repositories.UserRepository;
import IRCTC.booking.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MockitoExample {

    @Autowired
    @InjectMocks
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testSomething() throws TicketingCustomException {
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(Optional.ofNullable(User.builder().name("Ashhar").build()));
        Assertions.assertNotNull(userService.getUser("Ashhar"));
    }
}
