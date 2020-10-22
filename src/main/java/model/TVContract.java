package model;

import java.util.Calendar;

public class TVContract {
    private int id;
    private Calendar start;
    private Calendar finish;
    private User user;
    private CanalPackage canalPackage;

    /**
     *
     * @return boolean
     */
    public boolean validateContract(){
        if (start.compareTo(finish) > 0 || start.compareTo(Calendar.getInstance()) > 0){
            return false;
        }
        return true;
    }
    
    public TVContract(int id,
                      Calendar start,
                      Calendar finish,
                      User user,
                      CanalPackage canalPackage) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.user = user;
        this.canalPackage=canalPackage;
    }

    public TVContract(int id) {
        this.id = id;
    }

    public CanalPackage getCanalPackage() {
        return canalPackage;
    }

    public void setCanalPackage(CanalPackage canalPackage) {
        this.canalPackage = canalPackage;
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
