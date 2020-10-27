package factory;

import model.Contract;
import model.InternetContract;
import model.User;

import java.util.Calendar;

public class InternetContractFactory extends Factory {

    @Override
    public Contract createContract(int id) {
        return new InternetContract(id);
    }

    public Contract createContract(int id,
                            Calendar start,
                            Calendar finish,
                            User user,
                            int maxInternetSpeedMb) {
        return new InternetContract(id, start, finish, user, maxInternetSpeedMb);
    }
}
