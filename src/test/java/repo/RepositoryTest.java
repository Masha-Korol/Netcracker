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
    void getAllInternetContracts() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getAllInternetContracts());
    }

    @Test
    void getAllPhoneContracts() {
        Repository repository = new Repository();
        Factory factory = new PhoneContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getAllPhoneContracts());
    }

    @Test
    void getAllTVContracts() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getAllTVContracts());
    }

    @Test
    void addContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        Contract contract = factory.createContract(0);
        repository.addContract(contract);
        assertNotNull(repository.getTVContract(contract.getId()));
    }

    @Test
    void deleteInternetContract() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        repository.addContract(factory.createContract(0));
        repository.deleteInternetContract(0);
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.deleteInternetContract(1));
    }

    @Test
    void deletePhoneContract() {
        Repository repository = new Repository();
        Factory factory = new PhoneContractFactory();
        repository.addContract(factory.createContract(0));
        repository.deletePhoneContract(0);
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.deletePhoneContract(1));
    }

    @Test
    void deleteTVContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        repository.addContract(factory.createContract(0));
        repository.deleteTVContract(0);
        assertNull(repository.getTVContract(0));
        assertFalse(repository.deleteTVContract(1));
    }

    @Test
    void getInternetContract() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getInternetContract(0));
    }

    @Test
    void getPhoneContract() {
        Repository repository = new Repository();
        Factory factory = new PhoneContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getPhoneContract(0));
    }

    @Test
    void getTVContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        repository.addContract(factory.createContract(0));
        assertNotNull(repository.getTVContract(0));
    }

    @Test
    void replaceInternetContract() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        Contract contract1 = factory.createContract(0);
        Contract contract2 = factory.createContract(1);
        repository.addContract(contract1);
        assertTrue(repository.replaceInternetContract(0, contract2));
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.replaceInternetContract(2, contract1));
    }

    @Test
    void replacePhoneContract() {
        Repository repository = new Repository();
        Factory factory = new PhoneContractFactory();
        Contract contract1 = factory.createContract(0);
        Contract contract2 = factory.createContract(1);
        repository.addContract(contract1);
        assertTrue(repository.replacePhoneContract(0, contract2));
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.replacePhoneContract(2, contract1));
    }

    @Test
    void replaceTVContract() {
        Repository repository = new Repository();
        Factory factory = new TVContractFactory();
        Contract contract1 = factory.createContract(0);
        Contract contract2 = factory.createContract(1);
        repository.addContract(contract1);
        assertTrue(repository.replaceTVContract(0, contract2));
        assertNull(repository.getTVContract(0));
        assertFalse(repository.replaceTVContract(2, contract1));
    }

    @Test
    void trimArray() {
        Repository repository = new Repository();
        InternetContractFactory internetContractFactory = new InternetContractFactory();
        PhoneContractFactory phoneContractFactory = new PhoneContractFactory();
        TVContractFactory tvContractFactory = new TVContractFactory();
        Contract internetContract1 = internetContractFactory.createContract(0);
        Contract internetContract2 = internetContractFactory.createContract(1);
        Contract phoneContract = phoneContractFactory.createContract(0);
        Contract tvContract = tvContractFactory.createContract(0);
        repository.addContract(internetContract1);
        repository.addContract(phoneContract);
        repository.addContract(internetContract2);
        repository.addContract(tvContract);
        repository.deleteInternetContract(1);
        Contract[] expected = new Contract[repository.getAllContracts().length];
        expected[0] = internetContract1;
        expected[1] = phoneContract;
        expected[2] = tvContract;
        repository.trimArray();
        assertArrayEquals(expected, repository.getAllContracts());
    }
}