package com.test.projetobeneficiario.config;

import com.test.projetobeneficiario.service.exception.ValorDeAnoErradoExcpetion;
import javassist.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class HandlerRestException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(
            NotFoundException ex, WebRequest request) {

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Resource not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Erro na requisição");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ValorDeAnoErradoExcpetion.class)
    public ResponseEntity<Object> handleAnoErradoException(
            ValorDeAnoErradoExcpetion ex, WebRequest request) {

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Valor de anos não pode ser 0");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(
            HttpClientErrorException.BadRequest ex, WebRequest request) {

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Os dados enviados na requisição não são válidos");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
