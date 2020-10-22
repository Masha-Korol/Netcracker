package model;

import java.text.SimpleDateFormat;

public class TVContract {
    private int id;
    private SimpleDateFormat start;
    private SimpleDateFormat finish;
    private User user;

    private CanalPackage canalPackage;

    public TVContract(int id,
                      SimpleDateFormat start,
                      SimpleDateFormat finish,
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
