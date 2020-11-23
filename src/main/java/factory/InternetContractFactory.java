package factory;

import model.Contract;
import model.InternetContract;
import model.User;

import java.util.Calendar;

/**
 * contains methods for internet contracts creating
 */
public class InternetContractFactory extends Factory {

    @Override
    public Contract createContract(Integer id) {
        return new InternetContract(id);
    }

    @Override
    public Contract createContract(Integer id, Calendar start, Calendar finish, User user) {
        return new InternetContract(id, start, finish, user);
    }

    public Contract createContract(Integer id,
                                   Calendar start,
                                   Calendar finish,
                                   User user,
                                   int maxInternetSpeedMb) {
        return new InternetContract(id, start, finish, user, maxInternetSpeedMb);
    }
}
