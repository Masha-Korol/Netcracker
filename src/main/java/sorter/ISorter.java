package sorter;

import model.Contract;

import java.util.Comparator;

public interface ISorter {
    /**
     * sorts passed array
     * @param contracts array of contracts
     * @param comparator criteria (property) by which you do the sort
     */
    void sort(Contract[] contracts, Comparator<Contract> comparator);
}
