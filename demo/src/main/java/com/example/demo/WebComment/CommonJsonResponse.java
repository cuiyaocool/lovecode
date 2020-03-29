package com.example.demo.WebComment;

/**
 * @author cuiyaocy
 */
public class CommonJsonResponse<T> {

    public static final String MSG_SUCCESS = "SUCCESS";
    public static final String MSG_NOT_FOUND = "NOT FOUND";
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_NO_SUCH_OBJECT = 404;
    /**
     * 200 OK, 500 internal error, mapping of response code
     */
    private int status;
    /**
     * 0 means success
     */
    private int errorCode;

    /**
     * SUCCESS or others
     */
    private String msg;

    /**
     * the result data, may user info or others
     */
    private T data;

    public CommonJsonResponse() {
    }

    public CommonJsonResponse(int status, int errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public CommonJsonResponse(int status, int errorCode, String msg) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
