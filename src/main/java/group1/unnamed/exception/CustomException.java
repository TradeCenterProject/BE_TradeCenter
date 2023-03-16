package group1.unnamed.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

    private static final long serialVersionUID = 4663380430591151694L;

    private ExceptionConstants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public CustomException(ExceptionConstants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public ExceptionConstants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() { return httpStatus; }
}