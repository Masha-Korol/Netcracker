package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * represents an internet contract
 */
@XmlRootElement(name = "internet_contract")
public class InternetContract extends Contract {

    private int maxInternetSpeedMb;

    public InternetContract() {}

    public InternetContract(Integer id,
                            Calendar start,
                            Calendar finish,
                            User user,
                            int maxInternetSpeedMb) {
        this.setId(id);
        this.setStart(start);
        this.setFinish(finish);
        this.setUser(user);
        this.setMaxInternetSpeedMb(maxInternetSpeedMb);
    }

    public InternetContract(Integer id) {
        this.setId(id);
    }

    public InternetContract(Integer id, Calendar start, Calendar finish, User user){
        this.setId(id);
        this.setStart(start);
        this.setFinish(finish);
        this.setUser(user);
    }

    public int getMaxInternetSpeedMb() {
        return maxInternetSpeedMb;
    }

    public void setMaxInternetSpeedMb(int maxInternetSpeedMb) {
        this.maxInternetSpeedMb = maxInternetSpeedMb;
    }

    @Override
    public String toString() {
        return "InternetContract{" +
                "maxInternetSpeedMb=" + maxInternetSpeedMb +
                '}';
    }
}
