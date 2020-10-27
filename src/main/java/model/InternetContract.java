package model;

import java.util.Calendar;

public class InternetContract extends Contract {

    private int maxInternetSpeedMb;

    public InternetContract(int id,
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

    public InternetContract(int id) {
        this.setId(id);
    }

    public int getMaxInternetSpeedMb() {
        return maxInternetSpeedMb;
    }

    public void setMaxInternetSpeedMb(int maxInternetSpeedMb) {
        this.maxInternetSpeedMb = maxInternetSpeedMb;
    }
}
