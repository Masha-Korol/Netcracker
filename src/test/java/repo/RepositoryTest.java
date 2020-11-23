package repo;

import data.Data;
import data.DateValidator;
import data.UserValidator;
import factory.Factory;
import factory.InternetContractFactory;
import factory.TVContractFactory;
import model.Contract;
import model.User;
import org.assertj.core.internal.cglib.asm.$ClassReader;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private Repository repository;

    /*@BeforeClass
    public void initBeforeAll(){
        repository = new Repository();
    }*/
    //TODO настроить repository injection

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
    void getContractsByUser() {
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

        Repository repository1 = new Repository();
        repository1.addContract(contract1);
        repository1.addContract(contract3);

        PredicateFactory predicFactory = new PredicateFactory();
        assertArrayEquals(repository1.getAllContracts(), repository.getContracts(predicFactory.createUserPredicate(user1)).
                                                                                            getAllContracts());
    }

    @Test
    void getContractsById() {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        User user1 = new User(2, "a");
        User user2 = new User(1, "b");
        User user3 = new User(3, "c");
        Contract contract1 = factory.createContract(0, Calendar.getInstance(), Calendar.getInstance(), user1);
        Contract contract2 = factory.createContract(1, Calendar.getInstance(), Calendar.getInstance(), user2);
        Contract contract3 = factory.createContract(0, Calendar.getInstance(), Calendar.getInstance(), user3);
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);

        Repository repository1 = new Repository();
        repository1.addContract(contract1);
        repository1.addContract(contract3);

        PredicateFactory predicFactory = new PredicateFactory();
        assertArrayEquals(repository1.getAllContracts(), repository.getContracts(predicFactory.createIdPredicate(0)).
                getAllContracts());
    }

    @Test
    void getContractsByStart() throws ParseException {
        Repository repository = new Repository();
        Factory factory = new InternetContractFactory();
        User user1 = new User(2, "a");
        User user2 = new User(2, "b");
        User user3 = new User(3, "c");
        Calendar calendarStart1 = Calendar.getInstance();
        calendarStart1.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2003"));
        Calendar calendarStart2 = Calendar.getInstance();
        calendarStart2.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2004"));
        Calendar calendarStart3 = Calendar.getInstance();
        calendarStart3.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2003"));
        Calendar calendarFinish1 = Calendar.getInstance();
        calendarFinish1.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2005"));
        Calendar calendarFinish2 = Calendar.getInstance();
        calendarFinish2.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2005"));
        Calendar calendarFinish3 = Calendar.getInstance();
        calendarFinish3.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2005"));
        Contract contract1 = factory.createContract(0, calendarStart1, calendarFinish1, user1);
        Contract contract2 = factory.createContract(1, calendarStart2, calendarFinish2, user2);
        Contract contract3 = factory.createContract(2, calendarStart3, calendarFinish3, user3);
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);

        Repository repository1 = new Repository();
        repository1.addContract(contract1);
        repository1.addContract(contract3);
        
        PredicateFactory predicFactory = new PredicateFactory();
        assertArrayEquals(repository1.getAllContracts(), repository.getContracts(predicFactory.createStartPredicate(calendarStart1)).
                getAllContracts());
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
}