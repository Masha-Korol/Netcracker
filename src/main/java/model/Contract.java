package model;

import java.util.Calendar;

public abstract class Contract {

    private int id;
    private Calendar start;
    private Calendar finish;
    private User user;

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

    /**
     * checks contract data
     * @return boolean - validated or not
     */
    public boolean validateContract(Calendar start, Calendar finish){
        if (start.compareTo(finish) > 0 || start.compareTo(Calendar.getInstance()) > 0){
            return false;
        }
        return true;
    }
}
