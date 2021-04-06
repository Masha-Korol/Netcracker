package data;

import annotation.Injector;
import model.Contract;
import org.junit.jupiter.api.Test;
import repo.Repository;
import validator.DateValidator;
import validator.UserValidator;

import java.io.FileReader;
import java.lang.reflect.Method;

class DataTest {

    @Test
    void readFile() throws Exception {
        Repository repository = new Repository();
        Data data = new Data();
        Injector.inject(data);
        FileReader file = new FileReader("info.csv");
        DateValidator dateValidator = new DateValidator();
        UserValidator userValidator = new UserValidator();
        data.readFile(repository, file);
    }
}
