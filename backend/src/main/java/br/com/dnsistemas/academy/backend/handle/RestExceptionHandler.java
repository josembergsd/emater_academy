package br.com.dnsistemas.academy.backend.handle;

import br.com.dnsistemas.academy.backend.exception.BadRequestException;
import br.com.dnsistemas.academy.backend.exception.BadRequestExceptionDetails;
import br.com.dnsistemas.academy.backend.exception.ExceptionDetails;
import br.com.dnsistemas.academy.backend.exception.ValidationExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice //Informa para todos os controler utilizar essa classe diacordo com a flag
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Esception , Check the documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request){

        List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
        String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessages = fieldErros.stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Esception , invalid Fields")
                        .details(exception.getMessage())
                        .developerMessage(exception.getClass().getName())
                        .field(fields)
                        .fieldMessage(fieldsMessages)
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

         ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timeStamp(LocalDateTime.now())
                .status(status.value())
                .title(ex.getCause().getMessage())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(exceptionDetails, headers, status);
    }

}
