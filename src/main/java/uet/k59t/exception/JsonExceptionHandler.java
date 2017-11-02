package uet.k59t.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uet.k59t.controller.dto.ErrorDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lent on 4/20/2016.
 */
@ControllerAdvice
public class JsonExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private ObjectMapper mapper;

    public JsonExceptionHandler() {
        System.out.println("Exception handler is created");
    }

    @ExceptionHandler(InterceptorException.class)
    protected ResponseEntity<String> handleException(InterceptorException e, WebRequest request, HttpServletResponse response) throws JsonProcessingException {
        return handleCommonExceptions(request, e, response);
    }

    private ResponseEntity handleCommonExceptions(WebRequest request, InterceptorException responseException, HttpServletResponse response) throws JsonProcessingException {
        HttpStatus responseStatus;
        if (null != responseException.getHttpStatus()) {
            responseStatus = responseException.getHttpStatus();
        } else {
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatusCode("" + responseStatus.value());
        errorDTO.setStatusDescription(responseStatus.getReasonPhrase());
        errorDTO.setErrorMessage(responseException.getMessage());
        errorDTO.setOriginalExceptionType(responseException.getClass().getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(responseException, mapper.writeValueAsString(errorDTO), headers, responseStatus, request);
    }
}