package model;

import java.util.Calendar;

public class PhoneContract extends Contract {

    private int mbInternet;
    private int sms;

    public PhoneContract(int id,
                         Calendar start,
                         Calendar finish,
                         User user,
                         int mbInternet,
                         int sms) {
        this.setId(id);
        this.setStart(start);
        this.setFinish(finish);
        this.setUser(user);
        this.mbInternet = mbInternet;
        this.sms = sms;
    }

    public PhoneContract(int id) {
    this.setId(id);
    }

    public int getMbInternet() {
        return mbInternet;
    }

    public void setMbInternet(int mbInternet) {
        this.mbInternet = mbInternet;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }
}
