package IRCTC.booking.customexceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomExceptionResponse {

    String errorMessage;
    String suggestedAction;
    String statusCode;


}
