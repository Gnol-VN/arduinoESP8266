package uet.k59t.controller.dto;

public class ErrorDTO {
// ------------------------------ FIELDS ------------------------------

    private String statusCode;
    private String statusDescription;
    private String errorMessage;
    private String originalExceptionType;

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getOriginalExceptionType() {
        return originalExceptionType;
    }

    public void setOriginalExceptionType(String originalExceptionType) {
        this.originalExceptionType = originalExceptionType;
    }

// -------------------------- INNER CLASSES --------------------------

//    public static interface Properties {
//        public static final String STATUS_CODE = "statusCode";
//        public static final String STATUS_DESCRIPTION = "statusDescription";
//        public static final String ERROR_MESSAGE = "errorMessage";
//        public static final String ADDITION_INFO = "additionInfo";
//        public static final String OBJECT = "object";
//    }
}
