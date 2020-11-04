package data;

import factory.InternetContractFactory;
import factory.PhoneContractFactory;
import factory.TVContractFactory;
import model.User;
import model.enums.CanalPackage;
import model.enums.Sex;
import repo.Repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {

    private User[] users = new User[100];
    private int countUsers = 0;

    /**
     * reads from file data to repository
     * @param repository
     * @param file - fileReader
     * @throws Exception - in case something wrong with the file
     */
    public void readFile(Repository repository, FileReader file) throws Exception {

        BufferedReader reader = new BufferedReader(file);
        User user;
        String line;
        String[] string;

        reader.readLine();
        reader.readLine();
        line = reader.readLine();

        while (line != null) {

            try {
                string = line.split(";");

                Calendar calendarStart = Calendar.getInstance();
                Calendar calendarFinish = Calendar.getInstance();
                calendarStart.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(string[1]));
                calendarFinish.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(string[2]));

                String[] passport = string[7].split(" ");
                user = makeUser(string[3], string[4], string[6], string[5], passport);

                makeContract(string[0], calendarStart, calendarFinish,
                             string[8], string[9], user, repository);

                line = reader.readLine();

            } catch (Exception e) {
                e.printStackTrace();
                line = reader.readLine();
            }
        }
    }

    private void makeContract(String id,
                              Calendar start, Calendar finish,
                              String type, String addInfo,
                              User user, Repository repository){

        InternetContractFactory internetFactory = new InternetContractFactory();
        PhoneContractFactory phoneFactory = new PhoneContractFactory();
        TVContractFactory tvFactory = new TVContractFactory();

        switch (type.toLowerCase()) {
            case "internet":
                String[] speed = addInfo.split(":");
                repository.addContract(internetFactory.createContract(Integer.parseInt(id),
                        start, finish, user, Integer.parseInt(speed[1])));
                break;
            case "phone":
                String[] mb = addInfo.split(" ")[0].split(":");
                String[] sms = addInfo.split(" ")[1].split(":");
                repository.addContract(phoneFactory.createContract(Integer.parseInt(id),
                        start, finish, user,
                        Integer.parseInt(mb[1]), Integer.parseInt(sms[1])));
                break;
            case "tv":
                String[] pack = addInfo.split(":");
                CanalPackage canalPackage;
                switch (pack[1].toLowerCase()) {
                    case "sport":
                        canalPackage = CanalPackage.SPORT;
                        break;
                    case "family":
                        canalPackage = CanalPackage.FAMILY;
                        break;
                    case "children":
                        canalPackage = CanalPackage.CHILDREN;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + pack[1].toLowerCase());
                }

                repository.addContract(tvFactory.createContract(Integer.parseInt(id),
                        start, finish, user, canalPackage));
        }

    }

    private User makeUser(String id, String lastName, String birth, String sex, String[] passport) throws ParseException {
        Calendar calendarBirth = Calendar.getInstance();
        calendarBirth.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(birth));
        User user = new User(Integer.parseInt(id),
                lastName, calendarBirth, defineSex(sex),
                Integer.parseInt(passport[0]),
                Integer.parseInt(passport[1]));

        boolean doesUserExist = false;
        for (int i = 0; i < countUsers; i++) {
            if (user.isUserSameAs(users[i])) {
                doesUserExist = true;
                user = users[i];
                break;
            }
        }

        if(doesUserExist == false){
            if (countUsers == users.length) {
                User[] users_new = new User[countUsers * 2];
                for (int i = 0; i < countUsers; i++) {
                    users_new[i] = users[i];
                }
                users = users_new;
            }
            users[countUsers++] = user;
        }

        return user;
    }

    private Sex defineSex(String sex){
        if (sex.equals("M")) {
            return Sex.MALE;
        } else {
            return Sex.FEMALE;
        }
    }
}
