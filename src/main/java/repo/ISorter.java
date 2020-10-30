package repo;

import model.Contract;

public interface ISorter {
    /**
     * sorts passed array
     * @param contracts array of contracts
     * @param crit criteria (property) by which you do the sort
     * @param count size of array (number of objects)
     */
    void sort(Contract[] contracts, String crit, int count);
}
