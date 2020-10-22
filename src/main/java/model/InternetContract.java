package model;

import java.text.SimpleDateFormat;

public class InternetContract {
    private int id;
    private SimpleDateFormat start;
    private SimpleDateFormat finish;
    private User user;

    private int maxInternetSpeedMb;

    public InternetContract(int id,
                            SimpleDateFormat start,
                            SimpleDateFormat finish,
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
