package model;

import java.util.Calendar;

public class TVContract extends Contract {
    private CanalPackage canalPackage;

    public TVContract(int id,
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

    public TVContract(int id) {
        this.setId(id);
    }

    public CanalPackage getCanalPackage() {
        return canalPackage;
    }

    public void setCanalPackage(CanalPackage canalPackage) {
        this.canalPackage = canalPackage;
    }

}
