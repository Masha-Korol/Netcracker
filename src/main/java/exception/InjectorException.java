package exception;

/**
 * This exception is used to handle exceptions and errors that can appear as a result of using @Injector annotation
 * This exception is thrown in case target property is not list and there's more than one or none suitable classes were found
 * This exception also wraps handling:
 * IOException in case there's problem with finding classes in defined package
 * InstantiationException and IllegalAccessException in case some problems with creating an instance of a class appeared
 */
public class InjectorException extends Exception {
    public InjectorException(Exception e) {
        super(e);
    }

    public InjectorException(String message) {
        super(message);
    }

    public InjectorException() {
    }
}
