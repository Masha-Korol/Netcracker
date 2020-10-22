package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String lastName;
    private SimpleDateFormat birth;
    private Sex sex;
    private long passportNumber;
    private long passportSeries;

    public User(int id,
                String lastName,
                SimpleDateFormat birth,
                Sex sex,
                long passportNumber,
                long passportSeries) {
        this.id = id;
        this.lastName = lastName;
        this.birth = birth;
        this.sex = sex;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
    }

    public User(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SimpleDateFormat getBirth() {
        return birth;
    }

    public void setBirth(SimpleDateFormat birth) {
        this.birth = birth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(Long passportSeries) {
        this.passportSeries = passportSeries;
    }
}
