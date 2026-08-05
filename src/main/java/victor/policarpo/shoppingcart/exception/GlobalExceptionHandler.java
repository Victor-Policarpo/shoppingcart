package victor.policarpo.shoppingcart.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExistsException(ResourceAlreadyExistsException e, HttpServletRequest http){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage(e.getMessage());
        err.setError("Conflict");
        err.setPath(http.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

}
