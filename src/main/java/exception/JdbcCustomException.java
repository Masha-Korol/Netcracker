package exception;

/**
 * This exception is used to handle exceptions and errors that can appear as a result of using JdbcParser
 * This exception wraps handling:
 * NoSuchMethodException - if there's a problem with getting method "getAllContracts" by name
 * IllegalAccessException, InvocationTargetException - if there's a problem with invoking method gotten by name getAllContracts
 * SQLException - if there's something wrong with sql request
 */
public class JdbcCustomException extends Exception {
    public JdbcCustomException(Throwable cause) {
        super(cause);
    }
}
