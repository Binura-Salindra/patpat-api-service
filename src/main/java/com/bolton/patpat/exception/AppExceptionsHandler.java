package com.bolton.patpat.exception;



import com.bolton.patpat.dto.json.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.bolton.patpat.constant.ResponseCodes.INTERNAL_SERVER_ERROR;


@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CommonResponse> handleAnyException(Exception ex, WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new CommonResponse(INTERNAL_SERVER_ERROR, "An unexpected error occurred. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<CommonResponse> handleCustomException(CustomException ex, WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new CommonResponse(ex.getStatus(), ex.getMessage()), HttpStatus.OK);
    }

}
