package data;

import org.junit.jupiter.api.Test;
import repo.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void readFile() throws Exception {
        Repository repository = new Repository();
        Data data = new Data();
        FileReader file = new FileReader("info.csv");
        DateValidator dateValidator = new DateValidator();
        UserValidator userValidator = new UserValidator();
        data.readFile(repository, file, dateValidator, userValidator);
        repository.getAllContracts();
    }
}