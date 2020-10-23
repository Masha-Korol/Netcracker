package repo;

import model.Contract;
import model.InternetContract;
import model.PhoneContract;
import model.TVContract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void getAllInternetContracts() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addContract(internetContract);
        assertNotNull(repository.getAllInternetContracts());
    }

    @Test
    void getAllPhoneContracts() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addContract(phoneContract);
        assertNotNull(repository.getAllPhoneContracts());
    }

    @Test
    void getAllTVContracts() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addContract(tvContract);
        assertNotNull(repository.getAllTVContracts());
    }

    @Test
    void addContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addContract(tvContract);
        assertNotNull(repository.getTVContract(tvContract.getId()));
    }

    @Test
    void deleteInternetContract() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addContract(internetContract);
        repository.deleteInternetContract(0);
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.deleteInternetContract(1));
    }

    @Test
    void deletePhoneContract() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addContract(phoneContract);
        repository.deletePhoneContract(0);
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.deletePhoneContract(1));
    }

    @Test
    void deleteTVContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addContract(tvContract);
        repository.deleteTVContract(0);
        assertNull(repository.getTVContract(0));
        assertFalse(repository.deleteTVContract(1));
    }

    @Test
    void getInternetContract() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addContract(internetContract);
        assertNotNull(repository.getInternetContract(0));
    }

    @Test
    void getPhoneContract() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addContract(phoneContract);
        assertNotNull(repository.getPhoneContract(0));
    }

    @Test
    void getTVContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addContract(tvContract);
        assertNotNull(repository.getTVContract(0));
    }

    @Test
    void replaceInternetContract() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addContract(internetContract);
        InternetContract internetContract1 = new InternetContract(1);
        assertTrue(repository.replaceInternetContract(0, internetContract1));
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.replaceInternetContract(2, internetContract));
    }

    @Test
    void replacePhoneContract() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addContract(phoneContract);
        PhoneContract phoneContract1 = new PhoneContract(1);
        assertTrue(repository.replacePhoneContract(0, phoneContract1));
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.replacePhoneContract(2, phoneContract));
    }

    @Test
    void replaceTVContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addContract(tvContract);
        TVContract tvContract1 = new TVContract(1);
        assertTrue(repository.replaceTVContract(0, tvContract1));
        assertNull(repository.getTVContract(0));
        assertFalse(repository.replaceTVContract(2, tvContract));
    }

    @Test
    void trimArray() {
        Repository repository = new Repository();
        Contract internetContract = new InternetContract(0);
        Contract internetContract1 = new InternetContract(1);
        Contract phoneContract = new PhoneContract(0);
        Contract tvContract = new TVContract(0);
        repository.addContract(internetContract);
        repository.addContract(phoneContract);
        repository.addContract(internetContract1);
        repository.addContract(tvContract);
        repository.deleteInternetContract(1);
        Contract[] expected = new Contract[repository.getAllContracts().length];
        expected[0] = internetContract;
        expected[1] = phoneContract;
        expected[2] = tvContract;
        repository.trimArray();
        assertArrayEquals(expected, repository.getAllContracts());
    }
}