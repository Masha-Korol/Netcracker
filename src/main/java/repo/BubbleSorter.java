package repo;

import model.Contract;

import java.util.Comparator;

/**
 *
 */
public class BubbleSorter implements ISorter {

    /**
     * sorts array of contracts with bubble sort
     * @param contracts array of contracts
     * @param comparator criteria (property) by which you do the sort
     */
    @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        int count = 0;
        while(contracts[count] != null){
            count++;
        }

        for(int i = 0; i < count - 1; i++){
            for(int j = 0; j < count - i - 1; j++){
                if(comparator.compare(contracts[j], contracts[j + 1]) > 0){
                    Contract contract = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = contract;
                }
            }
        }
    }
}
