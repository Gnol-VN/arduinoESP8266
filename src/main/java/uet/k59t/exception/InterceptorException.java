package uet.k59t.exception;

import org.springframework.http.HttpStatus;

public class InterceptorException extends Exception {
    private HttpStatus httpStatus;

    public InterceptorException() {
    }

    public InterceptorException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
