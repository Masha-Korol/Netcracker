package factory;

import model.Contract;
import model.TVContract;
import model.User;
import model.enums.CanalPackage;

import java.util.Calendar;

/**
 * contains methods for tv contracts creating
 */
public class TVContractFactory extends Factory {

    @Override
    public Contract createContract(Integer id) {
    return new TVContract(id);
    }

    @Override
    public Contract createContract(Integer id, Calendar start, Calendar finish, User user) {
        return new TVContract(id, start, finish, user);
    }

    public Contract createContract(Integer id,
                      Calendar start,
                      Calendar finish,
                      User user,
                      CanalPackage canalPackage) {
        return new TVContract(id, start, finish, user, canalPackage);
    }
}
