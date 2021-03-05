package br.com.dnsistemas.academy.backend.exception.handle;

import br.com.dnsistemas.academy.backend.exception.BadExceptionRequestDetails;
import br.com.dnsistemas.academy.backend.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //Informa para todos os controler utilizar essa classe diacordo com a flag
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadExceptionRequestDetails> handlerBadRequestException(BadRequestException bre){
        return new ResponseEntity<>(
                BadExceptionRequestDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Esception , Check the documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
