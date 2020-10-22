package repo;

import model.InternetContract;
import model.PhoneContract;
import model.TVContract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void getAllInternetC() {
        Repository repository = new Repository();
        assertNotNull(repository.getAllInternetContracts());
    }

    @Test
    void getAllPhoneC() {
        Repository repository = new Repository();
        assertNotNull(repository.getAllPhoneContracts());
    }

    @Test
    void getAllTVC() {
        Repository repository = new Repository();
        assertNotNull(repository.getAllTVContracts());
    }

    @Test
    void addInternetC() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addInternetContract(internetContract);
        assertNotNull(repository.getInternetContract(internetContract.getId()));
    }

    @Test
    void addPhoneC() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addPhoneContract(phoneContract);
        assertNotNull(repository.getPhoneContract(phoneContract.getId()));
    }

    @Test
    void addTVC() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addTVContract(tvContract);
        assertNotNull(repository.getTVContract(tvContract.getId()));
    }

    @Test
    void deleteInternetC() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addInternetContract(internetContract);
        repository.deleteInternetContract(0);
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.deleteInternetContract(1));
    }

    @Test
    void deletePhoneC() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addPhoneContract(phoneContract);
        repository.deletePhoneContract(0);
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.deletePhoneContract(1));
    }

    @Test
    void deleteTVC() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addTVContract(tvContract);
        repository.deleteTVContract(0);
        assertNull(repository.getTVContract(0));
        assertFalse(repository.deleteTVContract(1));
    }

    @Test
    void getInternetContract() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addInternetContract(internetContract);
        assertNotNull(repository.getInternetContract(0));
    }

    @Test
    void getPhoneContract() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addPhoneContract(phoneContract);
        assertNotNull(repository.getPhoneContract(0));
    }

    @Test
    void getTVContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addTVContract(tvContract);
        assertNotNull(repository.getTVContract(0));
    }

    @Test
    void replaceInternetContract() {
        Repository repository = new Repository();
        InternetContract internetContract = new InternetContract(0);
        repository.addInternetContract(internetContract);
        InternetContract internetContract1 = new InternetContract(1);
        assertTrue(repository.replaceInternetContract(0, internetContract1));
        assertNull(repository.getInternetContract(0));
        assertFalse(repository.replaceInternetContract(2, internetContract));
    }

    @Test
    void replacePhoneContract() {
        Repository repository = new Repository();
        PhoneContract phoneContract = new PhoneContract(0);
        repository.addPhoneContract(phoneContract);
        PhoneContract phoneContract1 = new PhoneContract(1);
        assertTrue(repository.replacePhoneContract(0, phoneContract1));
        assertNull(repository.getPhoneContract(0));
        assertFalse(repository.replacePhoneContract(2, phoneContract));
    }

    @Test
    void replaceTVContract() {
        Repository repository = new Repository();
        TVContract tvContract = new TVContract(0);
        repository.addTVContract(tvContract);
        TVContract tvContract1 = new TVContract(1);
        assertTrue(repository.replaceTVContract(0, tvContract1));
        assertNull(repository.getTVContract(0));
        assertFalse(repository.replaceTVContract(2, tvContract));
    }
}