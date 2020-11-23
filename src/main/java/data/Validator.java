package data;

import model.Contract;

public abstract class Validator {

    private int error;
    private String message;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    abstract Validator validate(Contract contract);

    @Override
    public String toString() {
        return "Validator{" +
                "error=" + error +
                ", message='" + message + '\'' +
                '}';
    }
}
