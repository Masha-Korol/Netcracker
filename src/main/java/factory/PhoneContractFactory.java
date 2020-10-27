package factory;

import model.Contract;
import model.PhoneContract;
import model.User;

import java.util.Calendar;

public class PhoneContractFactory extends Factory {
    @Override
    public Contract createContract(int id) {
    return new PhoneContract(id);
    }

    public Contract createContract(int id,
                                   Calendar start,
                                   Calendar finish,
                                   User user,
                                   int mbInternet,
                                   int sms) {
        return new PhoneContract(id, start, finish, user, mbInternet, sms);
    }
}
