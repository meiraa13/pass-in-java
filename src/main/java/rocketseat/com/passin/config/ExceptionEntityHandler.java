package rocketseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.passin.domain.event.exceptions.EventIsFullException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handleCheckInAlreadyExists(CheckInAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @ExceptionHandler(EventIsFullException.class)
    public ResponseEntity handleEventFull(EventIsFullException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
