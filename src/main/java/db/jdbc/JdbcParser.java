package db.jdbc;

import data.Data;
import db.DataParser;
import exception.JdbcCustomException;
import model.*;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repo.Repository;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Locale;
import java.util.TimeZone;

public class JdbcParser implements DataParser {

    static Connection con;
    private static final Logger logger = LogManager.getLogger(JdbcParser.class);

    /**
     * sql request for inserting entity of the contract to the db
     */
    final String insertIntoContracts =
            "insert into contracts (id, start, finish, user_id, max_internet_speed_mb, " +
                    "mb_internet, sms, canal_package, contract_type) values (?,?,?,?,?,?,?,?,?)";
    /**
     * sql request for checking if user with given id exists in the db
     */
    final String checkIfUserExistsInDb = "select * from contract_users where id = ?";
    /**
     * sql request for inserting entity of the user to the db
     */
    final String insertIntoContractUsers = "insert into contract_users (id, last_name, birth, sex, passport_number, " +
            "passport_series) values (?,?,?,?,?,?)";

    private ContractStatementGenerator contractStatementGenerator = new ContractStatementGenerator();

    public JdbcParser(String userName, String password) {
        createConnection(userName, password);
    }

    /**
     * This method adds contracts from given repository to database
     * @param repository - repository which contains contracts
     * @throws JdbcCustomException - throws in case something wrong with reflection or sql
     */
    @Override
    public void addContracts(Repository repository) throws JdbcCustomException {
        try {
            Method getAllContracts = repository.getClass().getDeclaredMethod("getAllContracts");
            Object invoke = getAllContracts.invoke(repository);
            Contract[] all = (Contract[]) invoke;
            for (Contract contract : all) {
                if (contract != null) {
                    addUserIfNotExists(contract.getUser());
                    PreparedStatement pr = con.prepareStatement(insertIntoContracts);
                    pr = contractStatementGenerator.generateStatement(pr, contract);
                    if (pr != null) {
                        pr.executeUpdate();
                        logger.info("contract " + contract.toString() + " has been saved");
                    } else {
                        logger.warn("an error has occurred while saving contract " + contract.toString());
                    }
                }
            }
            seeAllContracts();
            seeAllContractUsers();
        } catch (NoSuchMethodException  | IllegalAccessException | InvocationTargetException | SQLException e) {
            throw new JdbcCustomException(e);
        }
    }

    /**
     * This method checks if user of the contract already exists in the database
     * @param user - user
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public void addUserIfNotExists(User user) throws SQLException {
        PreparedStatement pr = con.prepareStatement(checkIfUserExistsInDb);
        pr.setInt(1, user.getId());
        ResultSet resultSet = pr.executeQuery();
        Integer userId = null;
        while (resultSet.next()) {
            userId = resultSet.getInt(1);
        }
        if (userId == null) {
            addUser(user);
        } else {
            logger.info("user " + user.toString() + " already exists");
        }
    }

    /**
     * This method adds user to database
     * @param user - user to be added
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public void addUser(User user) throws SQLException {
        PreparedStatement pr = con.prepareStatement(insertIntoContractUsers);
        pr.setInt(1, user.getId());
        pr.setString(2, user.getLastName());
        java.util.Date start = user.getBirth().getTime();
        pr.setDate(3, new java.sql.Date(start.getTime()));
        pr.setString(4, user.getSex().toString());
        pr.setString(5, String.valueOf(user.getPassportNumber()));
        pr.setString(6, String.valueOf(user.getPassportSeries()));
        pr.executeUpdate();
        logger.info("user" + user.toString() + " has been saved");
    }

    /**
     * This method prints all the contracts from the database to console
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public void seeAllContracts() throws SQLException {
        PreparedStatement pr = con.prepareStatement("select * from contracts");
        ResultSet resultSet = pr.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + " ");
            System.out.print(resultSet.getString(2) + " ");
            System.out.print(resultSet.getString(3) + " ");
            System.out.print(resultSet.getString(4) + " ");
            System.out.print(resultSet.getString(5) + " ");
            System.out.print(resultSet.getString(6) + " ");
            System.out.print(resultSet.getString(7) + " ");
            System.out.print(resultSet.getString(8) + " ");
            System.out.println(resultSet.getString(9) + " ");
        }
    }

    /**
     * This method prints all the users from the database to console
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public void seeAllContractUsers() throws SQLException {
        PreparedStatement pr = con.prepareStatement("select * from contract_users");
        ResultSet resultSet = pr.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + " ");
            System.out.print(resultSet.getString(2) + " ");
            System.out.print(resultSet.getString(3) + " ");
            System.out.print(resultSet.getString(4) + " ");
            System.out.print(resultSet.getString(5) + " ");
            System.out.println(resultSet.getString(6) + " ");
        }
    }

    /**
     * This method creates database from script, passed as file path
     * @param filePath - path of the file with sql script
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public void initBd(String filePath) throws SQLException {
        Statement statement = con.createStatement();

        statement.executeUpdate("drop table if exists contracts");
        statement.executeUpdate("drop table if exists contract_users");

        ScriptRunner sc = new ScriptRunner(con);
        InputStream resourceAsStream = con.getClass().getClassLoader().
                getResourceAsStream(filePath);
        sc.runScript(new InputStreamReader(resourceAsStream));
    }

    /**
     * This method creates connection to database (mysql)
     * @param userName - user name in the database
     * @param password - password of this user
     */
    private void createConnection(String userName, String password){
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mk_bets?serverTimezone="
                    + TimeZone.getDefault().getID(),userName,password);
        } catch (SQLException | ClassNotFoundException ex) {
            con = null;
        }
    }
}
