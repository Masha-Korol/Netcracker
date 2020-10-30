package factory;

import model.Contract;
import model.User;

import java.util.Calendar;

public abstract class Factory {
    public abstract Contract createContract(Integer id);

    public abstract Contract createContract(Integer id, Calendar start, Calendar finish, User user);
}

