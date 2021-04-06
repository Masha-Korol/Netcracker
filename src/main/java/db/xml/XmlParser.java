package db.xml;

import db.DataParser;
import db.jdbc.JdbcParser;
import model.Contract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repo.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class XmlParser implements DataParser {

    /**
     * The path of the target xml file (where toy wanna save objects)
     */
    private String filePath;
    private static final Logger logger = LogManager.getLogger(XmlParser.class);

    public XmlParser(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method adds given repository with all the contracts to xml file with given path
     *
     * @param repository - repository with contracts
     * @throws JAXBException - throws in case there's something wrong with the xml parsing
     */
    @Override
    public void addContracts(Repository repository) throws JAXBException {
        saveObject(new File(filePath), repository);
    }

    /**
     * This method saves given entity to xml doc
     *
     * @param file       - file with given file path
     * @param repository - object to be saved
     * @throws JAXBException - throws in case there's something wrong with the xml parsing
     */
    private void saveObject(File file, Repository repository) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(repository.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(repository, file);
        logger.info("repository " + repository + " has been saved");
    }
}
