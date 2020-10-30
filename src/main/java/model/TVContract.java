package model;

import model.enums.CanalPackage;

import java.util.Calendar;

public class TVContract extends Contract {
    private CanalPackage canalPackage;

    public TVContract(Integer id,
                      Calendar start,
                      Calendar finish,
                      User user,
                      CanalPackage canalPackage) {
        this.setId(id);
        this.setStart(start);
        this.setFinish(finish);
        this.setUser(user);
        this.canalPackage = canalPackage;
    }

    public TVContract(Integer id) {
        this.setId(id);
    }

    public TVContract(Integer id, Calendar start, Calendar finish, User user){
        this.setId(id);
        this.setStart(start);
        this.setFinish(finish);
        this.setUser(user);
    }

    public CanalPackage getCanalPackage() {
        return canalPackage;
    }

    public void setCanalPackage(CanalPackage canalPackage) {
        this.canalPackage = canalPackage;
    }

}
