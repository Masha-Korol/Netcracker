package validator;

import model.Contract;

public abstract class Validator {

    private String message;
    private ErrorStatus errorStatus;
    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    abstract public Validator validate(Contract contract);

    @Override
    public String toString() {
        return "Validator{" +
                "message='" + message + '\'' +
                ", errorStatus=" + errorStatus +
                ", errorString=" + errorString +
                '}';
    }
}
