package model;

import model.enums.CanalPackage;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * represents a tv contract
 */
@XmlRootElement(name = "tv_contract")
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

    public TVContract() {}

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

    @Override
    public String toString() {
        return "TVContract{" +
                "canalPackage=" + canalPackage +
                '}';
    }
}
