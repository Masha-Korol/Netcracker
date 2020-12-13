package mergesorter;

import model.Contract;
import sorter.ISorter;

import java.util.Comparator;

public class MergeSorter implements ISorter {

    /**
     * sorts array of contracts with merge sort
     * @param contracts array of contracts
     * @param comparator criteria (property) by which you do the sort
     */
    @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        int count = 0;
        while(contracts[count] != null){
            count++;
        }
        mergeSort(contracts, count, comparator);
    }

    private void mergeSort(Contract[] arrayA, int sizeA, Comparator<Contract> comparator){
        if (sizeA > 1){
            Contract[] arrayB = new Contract[sizeA / 2];
            Contract[] arrayC = new Contract[sizeA - sizeA / 2];

            for (int i = 0; i < sizeA / 2; i++)
                arrayB[i] = arrayA[i];
            for (int i = sizeA / 2; i < sizeA; i++)
                arrayC[i - sizeA / 2] = arrayA[i];

            mergeSort(arrayB, sizeA / 2, comparator);
            mergeSort(arrayC, sizeA - sizeA / 2, comparator);
            merge(arrayA, arrayB, arrayC, sizeA / 2, sizeA - sizeA / 2, comparator);
        }
    }

    private void merge(Contract[] arrayA, Contract[] arrayB, Contract[] arrayC,
                       int sizeB, int sizeC, Comparator<Contract> comparator){
        int i = 0, j = 0, k = 0;
        while (i < sizeB && j < sizeC)
        {
            if (comparator.compare(arrayC[j], arrayB[i]) > 0)
            {
                arrayA[k] = arrayB[i];
                i++;
            }
            else
            {
                arrayA[k] = arrayC[j];
                j++;
            }
            k++;
        }
        if (i == sizeB)
            for (int t = j; t < sizeC; t++)
                arrayA[k++] = arrayC[t];
        else
            for (int t = i; t < sizeB; t++)
                arrayA[k++] = arrayB[t];
    }
}
