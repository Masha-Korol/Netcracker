package db.jdbc;

import model.Contract;
import model.InternetContract;
import model.PhoneContract;
import model.TVContract;
import model.enums.ContractType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * This class is used to generate prepared statements for inserting the entity of contract
 * with the setting of the parameters depending on the class of the contract
 */
public class ContractStatementGenerator {

    /**
     * This method generates prepared statement for inserting contract to db
     * @param pr - created prepared statement
     * @param contract - contract to be added
     * @return - prepared statement with all needed parameters
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    public PreparedStatement generateStatement(PreparedStatement pr, Contract contract) throws SQLException {
        pr.setInt(1, contract.getId());
        java.util.Date start = contract.getStart().getTime();
        pr.setDate(2, new java.sql.Date(start.getTime()));
        java.util.Date finish = contract.getFinish().getTime();
        pr.setDate(3, new java.sql.Date(finish.getTime()));
        pr.setInt(4, contract.getUser().getId());
        pr = setSpecificFields(pr, contract);
        return pr;
    }

    /**
     * This method calls specific methods for filling the parameters for each type of the contract
     * @param pr - prepared statement
     * @param contract - contract to be added
     * @return - prepared statement
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    private PreparedStatement setSpecificFields(PreparedStatement pr, Contract contract) throws SQLException {
        if (contract instanceof InternetContract) {
            return setInternetContractFields(pr, (InternetContract) contract);
        } else if (contract instanceof PhoneContract) {
            return setPhoneContractFields(pr, (PhoneContract) contract);
        } else if (contract instanceof TVContract){
            return setTVContractFields(pr, (TVContract) contract);
        }
        return null;
    }

    /**
     * This method fills parameters for contract of type Internet
     * @param pr - prepared statement
     * @param contract
     * @return - prepared statement
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    private PreparedStatement setInternetContractFields(PreparedStatement pr, InternetContract contract) throws SQLException {
        pr.setInt(5, contract.getMaxInternetSpeedMb());
        pr.setNull(6, Types.INTEGER);
        pr.setNull(7, Types.INTEGER);
        pr.setNull(8, Types.VARCHAR);
        pr.setString(9, ContractType.INTERNET.toString());
        return pr;
    }

    /**
     * This method fills parameters for contract of type Phone
     * @param pr - prepared statement
     * @param contract
     * @return - prepared statement
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    private PreparedStatement setPhoneContractFields(PreparedStatement pr, PhoneContract contract) throws SQLException {
        pr.setNull(5, Types.INTEGER);
        pr.setInt(6, contract.getMbInternet());
        pr.setInt(7, contract.getSms());
        pr.setNull(8, Types.VARCHAR);
        pr.setString(9, ContractType.PHONE.toString());
        return pr;
    }

    /**
     * This method fills parameters for contract of type TV
     * @param pr - prepared statement
     * @param contract
     * @return - prepared statement
     * @throws SQLException - throws in case there's something wrong with sql request
     */
    private PreparedStatement setTVContractFields(PreparedStatement pr, TVContract contract) throws SQLException {
        pr.setNull(5, Types.INTEGER);
        pr.setNull(6, Types.INTEGER);
        pr.setNull(7, Types.INTEGER);
        pr.setString(8, contract.getCanalPackage().toString());
        pr.setString(9, ContractType.TV.toString());
        return pr;
    }
}
