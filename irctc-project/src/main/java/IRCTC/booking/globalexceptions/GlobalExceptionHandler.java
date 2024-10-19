package IRCTC.booking.globalexceptions;

import IRCTC.booking.customexceptions.TicketingCustomException;
import IRCTC.booking.customexceptions.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TicketingCustomException.class)
    public ResponseEntity<?> bookingException(TicketingCustomException e)
    {
        CustomExceptionResponse exceptionResponse = CustomExceptionResponse.builder().errorMessage(e.getMessage())
                .suggestedAction("Check error logs")
                .statusCode(HttpStatus.EXPECTATION_FAILED.toString()).build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
