package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PhoneContract {
    private int id;
    private Calendar start;
    private Calendar finish;
    private User user;

    private int mbInternet;
    private int sms;

    /**
     * checks contract data
     * @return boolean - validated or not
     */
    public boolean validateContract(){
        if (start.compareTo(finish) > 0 || start.compareTo(Calendar.getInstance()) > 0){
            return false;
        }
        return true;
    }

    public PhoneContract(int id,
                         Calendar start,
                         Calendar finish,
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

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getFinish() {
        return finish;
    }

    public void setFinish(Calendar finish) {
        this.finish = finish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
