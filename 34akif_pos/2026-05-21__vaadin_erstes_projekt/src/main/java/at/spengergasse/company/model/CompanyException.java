package at.spengergasse.company.model;

public class CompanyException extends Exception {

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}

