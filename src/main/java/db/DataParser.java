package db;

import exception.JdbcCustomException;
import model.Contract;
import repo.Repository;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DataParser {
    void addContracts(Repository repository) throws JAXBException, JdbcCustomException;
}
