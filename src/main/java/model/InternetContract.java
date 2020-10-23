package model;

import java.util.ArrayList;
import java.util.Calendar;

public class InternetContract extends Contract {
    private int id;
    private Calendar start;
    private Calendar finish;
    private User user;
    private int maxInternetSpeedMb;
    
    public InternetContract(int id,
                            Calendar start,
                            Calendar finish,
                            User user,
                            int maxInternetSpeedMb) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.user = user;
        this.maxInternetSpeedMb=maxInternetSpeedMb;
    }
    
    public InternetContract(int id) {
        this.id = id;
    }

    public int getMaxInternetSpeedMb() {
        return maxInternetSpeedMb;
    }

    public void setMaxInternetSpeedMb(int maxInternetSpeedMb) {
        this.maxInternetSpeedMb = maxInternetSpeedMb;
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
