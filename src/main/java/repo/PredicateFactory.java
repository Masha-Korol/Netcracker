package repo;

import model.Contract;
import model.User;

import java.util.Calendar;
import java.util.function.Predicate;

/**
 * contains methods for predicates creating
 */
public class PredicateFactory {
    public Predicate<Contract> createIdPredicate(int id){
       return o->o.getId() == id;
    }

    public Predicate<Contract> createStartPredicate(Calendar start){
        return o->o.getStart() .equals(start);
    }

    public Predicate<Contract> createFinishPredicate(Calendar finish){
        return o->o.getFinish().equals(finish);
    }

    public Predicate<Contract> createUserPredicate(User user){
        return o->o.getUser().equals(user);
    }
}
