package com.example.demo.exception;

/**
 * @author cuiyaocy
 */
public interface IServiceException {

    public enum ExceptionType {

        NOT_FOUND(404),
        REPEAT_REQUEST(601);

        private int errCode;
        private ExceptionType(int code) {
            errCode= code;
        }

        public int getErrCode() {
            return errCode;
        }


    }
    public ExceptionType getException();

}
