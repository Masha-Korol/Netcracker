package validator;

import model.Contract;

import java.util.Calendar;

import static validator.ErrorStatus.*;

/**
 * contains info about contract validation by user property: error code and massage
 */
public class UserValidator extends Validator {

    /**
     * this method defines whether the contract's data is valid
     * @param contract
     * @return validate entity
     */
    @Override
    public Validator validate(Contract contract) {

        if (contract.getUser().getBirth().compareTo(Calendar.getInstance()) > 0) {
            this.setMessage("birth date is not valid");
            this.setErrorStatus(ERROR);
            this.setErrorString(contract.getUser().getBirth().toString());
        } else if ((int) (Math.log10(contract.getUser().getPassportNumber()) + 1) != 4 ||
                (int) (Math.log10(contract.getUser().getPassportSeries()) + 1) != 6) {
            this.setMessage("passport data is not valid");
            this.setErrorStatus(ERROR);
            this.setErrorString(contract.getUser().getPassportNumber()+ " " +
                                contract.getUser().getPassportSeries());
        } else if (contract.getUser().getLastName().equals("")) {
            this.setMessage("user's name is null");
            this.setErrorStatus(WORN);
            this.setErrorString(contract.getUser().getId()+"");
        } else {
            this.setMessage("");
            this.setErrorStatus(OKAY);
        }
        return this;
    }
}
