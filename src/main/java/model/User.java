package model;

import model.enums.Sex;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import java.util.Objects;

/**
 * represents user
 */
@XmlRootElement(name = "user")
@XmlType(propOrder = {"id","lastName","birth", "sex", "passportNumber", "passportSeries", "age"})
public class User {
    private int id;
    private String lastName;
    private Calendar birth;
    private Sex sex;
    private long passportNumber;
    private long passportSeries;
    private int age;

    public User() {}

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
    }

    public User(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", sex=" + sex +
                ", passportNumber=" + passportNumber +
                ", passportSeries=" + passportSeries +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                passportNumber == user.passportNumber &&
                passportSeries == user.passportSeries &&
                age == user.age &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birth, user.birth) &&
                sex == user.sex;
    }

    public boolean isUserSameAs(User user){
        return this.passportNumber == user.passportNumber &&
                this.passportSeries == user.passportSeries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, birth, sex, passportNumber, passportSeries, age);
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

    public long getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(long passportSeries) {
        this.passportSeries = passportSeries;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
