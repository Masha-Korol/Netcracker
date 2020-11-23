package factory;

import model.Contract;
import model.PhoneContract;
import model.User;

import java.util.Calendar;

/**
 * contains methods for phone contracts creating
 */
public class PhoneContractFactory extends Factory {
    @Override
    public Contract createContract(Integer id) {
    return new PhoneContract(id);
    }

    @Override
    public Contract createContract(Integer id, Calendar start, Calendar finish, User user) {
        return new PhoneContract(id, start, finish, user);
    }

    public Contract createContract(Integer id,
                                   Calendar start,
                                   Calendar finish,
                                   User user,
                                   int mbInternet,
                                   int sms) {
        return new PhoneContract(id, start, finish, user, mbInternet, sms);
    }
}
