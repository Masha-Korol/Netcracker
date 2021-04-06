package db.jdbc;

import annotation.Injector;
import data.Data;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import repo.Repository;
import validator.DateValidator;
import validator.UserValidator;
import java.io.FileReader;
import java.sql.*;

class JdbcParserTest {

    private Repository readDataFromFile(Repository repository) throws Exception {
        Data data = new Data();
        Injector.inject(data);
        FileReader file = new FileReader("info.csv");
        DateValidator dateValidator = new DateValidator();
        UserValidator userValidator = new UserValidator();
        data.readFile(repository, file);
        return repository;
    }

    @Test
    public void testConnection() throws SQLException {
        new JdbcParser("me", "1234");
        Assert.assertNotNull(JdbcParser.con);
    }



    @Test
    void addContracts() throws Exception {
        JdbcParser jdbcParser = new JdbcParser("me", "1234");
        jdbcParser.initBd("init-bd.sql");
        Repository repository = readDataFromFile(new Repository());
        jdbcParser.addContracts(repository);
    }
}
