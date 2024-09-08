package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.configs;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.exceptions.InvalidSortStringException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidSortStringException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSortStringException(InvalidSortStringException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
