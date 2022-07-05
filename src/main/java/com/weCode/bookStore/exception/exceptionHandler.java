package com.weCode.bookStore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = invalidFileException.class)
    public final ResponseEntity<ErrorMessage> SomthingWentwrong(invalidFileException ex){
        ErrorMessage exceptionResponse = new ErrorMessage("400","path",
                "The request body failed validation", ex.getC1());
        return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
class ErrorMessage{


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Cause> getCause() {
        return cause;
    }

    public void setCause(List<Cause> cause) {
        this.cause = cause;
    }



    public ErrorMessage(String status, String type, String title, List<Cause> cause) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.cause = cause;
    }
    private String status;
    private String type;
    private String title;
    private List<Cause> cause;

}
