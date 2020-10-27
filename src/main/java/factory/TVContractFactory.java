package factory;

import model.CanalPackage;
import model.Contract;
import model.TVContract;
import model.User;

import java.util.Calendar;

public class TVContractFactory extends Factory {

    @Override
    public Contract createContract(int id) {
    return new TVContract(id);
    }

    public Contract createContract(int id,
                      Calendar start,
                      Calendar finish,
                      User user,
                      CanalPackage canalPackage) {
        return new TVContract(id, start, finish, user, canalPackage);
    }
}
