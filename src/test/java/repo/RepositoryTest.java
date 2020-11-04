package repo;

import data.Data;
import factory.Factory;
import factory.InternetContractFactory;
import factory.TVContractFactory;
import model.Contract;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.Calendar;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void getAllContracts() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getAllContracts());
    }

    @Test
    void addContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        Contract contract = factory.createContract(0);
        repository.addContract(contract);
        assertNotNull(repository.getContract(contract.getId()));
    }

    @Test
    void deleteContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        repository.addContract(factory.createContract(0));
        repository.deleteContract(0);
        assertNull(repository.getContract(0));
        assertFalse(repository.deleteContract(1));
    }

    @Test
    void getContract() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getContract(0));
    }

    @Test
    void replaceContract() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        Contract contract1 = factory.createContract(0);
        Contract contract2 = factory.createContract(1);
        repository.addContract(contract1);
        assertTrue(repository.replaceContract(0, contract2));
        assertNull(repository.getContract(0));
        assertFalse(repository.replaceContract(2, contract1));
    }

    @Test
    void getContracts() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        User user1 = new User(2, "a");
        User user2 = new User(1, "b");
        User user3 = new User(2, "a");
        Contract contract1 = factory.createContract(0, Calendar.getInstance(), Calendar.getInstance(), user1);
        Contract contract2 = factory.createContract(1, Calendar.getInstance(), Calendar.getInstance(), user2);
        Contract contract3 = factory.createContract(2, Calendar.getInstance(), Calendar.getInstance(), user3);
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);

        PredicateFactory predicFactory = new PredicateFactory();
        Contract[] array = repository.getContracts(predicFactory.createUserPredicate(user1));
        assertTrue(repository.getContracts(predicFactory.createUserPredicate(user1)).length > 0);
    }

    @Test
    void sort() {
        Repository repository = new Repository();
        ComparatorFactory compFactory = new ComparatorFactory();
        Comparator<Contract> idComparator = compFactory.createIdComparator();

        Factory factory = new InternetContractFactory();
        User user1 = new User(2, "a");
        User user2 = new User(3, "b");
        User user3 = new User(1, "a");
        Contract contract1 = factory.createContract(2, Calendar.getInstance(), Calendar.getInstance(), user1);
        Contract contract2 = factory.createContract(1, Calendar.getInstance(), Calendar.getInstance(), user2);
        Contract contract3 = factory.createContract(3, Calendar.getInstance(), Calendar.getInstance(), user3);
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);
        Contract[] array = new Contract[repository.getAllContracts().length];
        array[0] = contract2;
        array[1] = contract1;
        array[2] = contract3;

        repository.sort(idComparator);

        assertArrayEquals(repository.getAllContracts(), array);
    }

    @Test
    void fileReader() throws Exception {
        Repository repository = new Repository();
        Data data = new Data();
        FileReader file = new FileReader("info.csv");
        data.readFile(repository, file);
        repository.getAllContracts();
    }
}