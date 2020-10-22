package model;

import org.joda.time.LocalDate;

import java.util.Calendar;

public class User {
    private int id;
    private String lastName;
    private Calendar birth;
    private Sex sex;
    private long passportNumber;
    private long passportSeries;
    private int age;

    /**
     * checks user data
     * @param birth
     * @return boolean - validated or not
     */
    public boolean validateUser(Calendar birth){
        if (birth.compareTo(Calendar.getInstance()) > 0){
            return false;
        }
        return true;
    }

    public User(int id,
                String lastName,
                Calendar birth,
                Sex sex,
                long passportNumber,
                long passportSeries) {
        this.id = id;
        this.lastName = lastName;
        this.birth = birth;
        this.sex = sex;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
        age = Calendar.getInstance().get(Calendar.YEAR) - birth.get(Calendar.YEAR) - 1;
        if (Calendar.getInstance().get(Calendar.MONTH) > birth.get(Calendar.MONTH) ||
                (Calendar.getInstance().get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
                        (Calendar.getInstance().get(Calendar.DATE) > birth.get(Calendar.DATE)))){
            age++;
        }
        //сделать валидацию данных и тесты к ней
    }

    public User(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }


    public int getAge() {
        return age;
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

    public Calendar getBirth() {
        return birth;
    }

    public void setBirth(Calendar birth) {
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
