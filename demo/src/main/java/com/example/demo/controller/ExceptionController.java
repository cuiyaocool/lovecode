package com.example.demo.controller;

import com.example.demo.WebComment.CommonJsonResponse;
import com.example.demo.exception.ApiException;
import com.example.demo.exception.IServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Map;

import static com.example.demo.exception.IServiceException.ExceptionType.NOT_FOUND;
import static com.example.demo.exception.IServiceException.ExceptionType.REPEAT_REQUEST;

/**
 * @author cuiyaocy
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    public class ErrorDTO {
        private Date timestamp;
        private Map<String, String[]> params;
        private String desc;

        public ErrorDTO(Date timestamp, Map<String, String[]> params, String desc) {
            this.timestamp = timestamp;
            this.params = params;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "data : " + timestamp + " desc : " + desc + " params : " + params.toString();
        }

    }

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<CommonJsonResponse<ErrorDTO>> handleYPMExceptions(ApiException ex, WebRequest request) {
        ErrorDTO errorDetails = new ErrorDTO(new Date(), request.getParameterMap(),
                request.getDescription(false));
        IServiceException.ExceptionType exType = ex.getException();
        if (exType == NOT_FOUND) {
            // 404
            CommonJsonResponse<ErrorDTO> response = new CommonJsonResponse<>(HttpStatus.NOT_FOUND.value(),
                    exType.getErrCode(), ex.getMessage());
            response.setData(errorDetails);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (exType == REPEAT_REQUEST) {
            CommonJsonResponse<ErrorDTO> response = new CommonJsonResponse<>(exType.getErrCode(),
                    exType.getErrCode(), ex.getMessage());
            response.setData(errorDetails);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            // catch as 200
            CommonJsonResponse<ErrorDTO> response = new CommonJsonResponse<>(HttpStatus.OK.value(),
                    exType.getErrCode(), ex.getMessage());
            response.setData(errorDetails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
