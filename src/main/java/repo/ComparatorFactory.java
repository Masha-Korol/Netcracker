package repo;

import model.Contract;

import java.util.Comparator;

public class ComparatorFactory {
    public Comparator<Contract> createIdComparator(){
        return (o1, o2) -> o1.getId() - o2.getId();
    }

    public Comparator<Contract> createUserComparator(){
        return (o1, o2) -> o1.getUser().getId() - o2.getUser().getId();
    }

    public Comparator<Contract> createStartComparator(){
        return (o1, o2) -> {
            if (o1.getStart().compareTo(o2.getStart()) > 0){
                return 1;
            }
            if(o1.getStart().compareTo(o2.getStart()) < 0){
                return -1;
            }
            return 0;
        };
    }

    public Comparator<Contract> createFinishComparator(){
        return (o1, o2) -> {
            if (o1.getFinish().compareTo(o2.getFinish()) > 0){
                return 1;
            }
            if(o1.getFinish().compareTo(o2.getFinish()) < 0){
                return -1;
            }
            return 0;
        };
    }
}
