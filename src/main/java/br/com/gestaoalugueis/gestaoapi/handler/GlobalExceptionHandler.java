package br.com.gestaoalugueis.gestaoapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream() // processa a lista de erros
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList()); // junta tudo em uma nova lista

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
