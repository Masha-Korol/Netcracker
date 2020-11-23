package data;

import model.Contract;

import java.util.Calendar;

/**
 * contains info about contract validation by date property: error code and massage
 */
public class DateValidator extends Validator {

    @Override
    public Validator validate(Contract contract) {
        if (contract.getStart().compareTo(contract.getFinish()) > 0 ||
                contract.getStart().compareTo(Calendar.getInstance()) < 0) {
            this.setMessage("finish date is earlier than start");
            this.setError(-1);
        } else if (contract.getStart().compareTo(contract.getFinish()) == 0) {
            this.setMessage("finish and start dates are equal");
            this.setError(0);
        } else {
            this.setMessage("");
            this.setError(1);
        }
        return this;
    }
}
