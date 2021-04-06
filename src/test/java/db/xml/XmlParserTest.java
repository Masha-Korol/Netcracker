package db.xml;

import annotation.Injector;
import data.Data;
import db.xml.XmlParser;
import model.Contract;
import org.junit.jupiter.api.Test;
import repo.Repository;
import validator.DateValidator;
import validator.UserValidator;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class XmlParserTest {

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
    void addContracts() throws Exception {
        XmlParser xmlParser = new XmlParser("src/main/java/db/xml/db.xml");
        Repository repository = readDataFromFile(new Repository());
        xmlParser.addContracts(repository);
    }
}
