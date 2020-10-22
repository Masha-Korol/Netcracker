package model;

import java.text.SimpleDateFormat;

public class PhoneContract {
    private int id;
    private SimpleDateFormat start;
    private SimpleDateFormat finish;
    private User user;

    private int mbInternet;
    private int sms;

    public PhoneContract(int id,
                         SimpleDateFormat start,
                         SimpleDateFormat finish,
                         User user,
                         int mbInternet,
                         int sms) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.user = user;
        this.mbInternet=mbInternet;
        this.sms=sms;
    }

    public PhoneContract(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleDateFormat getStart() {
        return start;
    }

    public void setStart(SimpleDateFormat start) {
        this.start = start;
    }

    public SimpleDateFormat getFinish() {
        return finish;
    }

    public void setFinish(SimpleDateFormat finish) {
        this.finish = finish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
