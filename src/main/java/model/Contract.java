package model;

import java.util.Calendar;

public abstract class Contract {

    /**
     * checks contract data
     * @return boolean - validated or not
     */
    public boolean validateContract(Calendar start, Calendar finish){
        if (start.compareTo(finish) > 0 || start.compareTo(Calendar.getInstance()) > 0){
            return false;
        }
        return true;
    }
}
