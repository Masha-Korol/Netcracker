package validator;

import model.Contract;
import java.util.Calendar;
import static validator.ErrorStatus.*;

/**
 * contains info about contract validation by date property: error code and massage
 */
public class DateValidator extends Validator {

    @Override
    public Validator validate(Contract contract) {
        if (contract.getStart().compareTo(contract.getFinish()) > 0) {
            this.setMessage("finish date is earlier than start");
            this.setErrorStatus(ERROR);
            this.setErrorString(contract.getStart()+" "+contract.getFinish());
        } else if (contract.getStart().compareTo(contract.getFinish()) == 0) {
            this.setMessage("finish and start dates are equal");
            this.setErrorStatus(WORN);
            this.setErrorString(contract.getStart().toString());
        } else {
            this.setMessage("");
            this.setErrorStatus(OKAY);
        }
        return this;
    }
}
