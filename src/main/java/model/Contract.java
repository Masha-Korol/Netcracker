package model;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;

@XmlType(propOrder = {"id","start","finish", "user"})
public abstract class Contract {

    private Integer id;
    private Calendar start;
    private Calendar finish;
    private User user;

    public Contract() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", start=" + start +
                ", finish=" + finish +
                ", user=" + user +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * checks contract data
     * @return boolean - validated or not
     */
    public boolean validateContract(Calendar start, Calendar finish){
        if (start.compareTo(finish) > 0 || start.equals(finish)){
            return false;
        }
        return true;
    }
}
