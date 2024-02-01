package com.example.cinema1.Config.Exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice  // Try/ catch ở tầng Controller
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomException.class) // ExceptionHandler: catch 1 class đươc khai báo bên trong hàm
    public ResponseEntity<CustomException> catchExceptionCustom(CustomException exception, HttpServletRequest request) {
        exception.setPath(request.getRequestURI());
        return ResponseEntity.status(exception.getStatus())
                .body(exception);
    }


    // Mehtod bắt lỗi validate
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleBindException(BindException e, HttpServletRequest request) {
        String errorMessage = "";
        if (e.getBindingResult().hasErrors()) {
            for (int i = 0; i < e.getBindingResult().getAllErrors().size(); i++) {
                errorMessage += e.getBindingResult().getAllErrors().get(i).getDefaultMessage();
                errorMessage += (i == e.getBindingResult().getAllErrors().size() - 1) ? "." : ", ";
            }
        }
        CustomException appException = new CustomException(errorMessage, 400, request.getRequestURI());
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getStatus()));
    }


    @ExceptionHandler(Exception.class) // Bắt các lỗi còn lại
    public ResponseEntity<CustomException> catchExceptionGlobal(Exception exception, HttpServletRequest request) {
        CustomException appException = new CustomException(exception.getMessage(), 500, request.getRequestURI());
        appException.setPath(request.getRequestURI());
        return ResponseEntity.status(appException.getStatus())
                .body(appException);
    }
}
