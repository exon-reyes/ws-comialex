package nova.it.common.exception;

import nova.it.common.util.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppException {
    @ExceptionHandler(TicketException.class)
    public ResponseEntity<RestResponse> ticketException(TicketException e) {
        return ResponseEntity.status(e.getCode()).body(RestResponse.builder().status(e.getCode()).message(e.getMessage()).build());
    }

    @ExceptionHandler(UnidadException.class)
    public ResponseEntity<RestResponse> unidadException(UnidadException e) {
        return ResponseEntity.status(e.getCode()).body(RestResponse.builder().status(e.getCode()).message(e.getMessage()).build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestResponse.builder().message("Errores en la solicitud").status(400).errors(errors).build());
    }
}
