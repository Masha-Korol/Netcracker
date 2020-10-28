package repo;

import factory.Factory;
import factory.InternetContractFactory;
import factory.PhoneContractFactory;
import factory.TVContractFactory;
import model.Contract;
import org.junit.jupiter.api.Test;

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
}