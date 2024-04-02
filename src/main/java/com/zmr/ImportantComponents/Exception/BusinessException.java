package com.zmr.ImportantComponents.Exception;

import com.zmr.ImportantComponents.RequestCode.RequestCode;

public class BusinessException extends RuntimeException {
    private String requestCode = RequestCode.OK.getCode();

    private String errorKey;

    private String errorMessage;

    public BusinessException(String errorMessage) {
        super(errorMessage, null);
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage, String code) {
        super(errorMessage, null);
        this.requestCode = code;
    }

    public BusinessException(String errorMessage, String code, String errorKey) {
        super(errorMessage, null);
        this.requestCode = code;
        this.errorKey = errorKey;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
