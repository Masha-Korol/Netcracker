package repo;

import model.Contract;

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

    private void mergeSort(Contract[] A, int sizeA, Comparator<Contract> comparator){
        if (sizeA > 1){
            Contract[] B = new Contract[sizeA / 2];
            Contract[] C = new Contract[sizeA - sizeA / 2];

            for (int i = 0; i < sizeA / 2; i++)
                B[i] = A[i];
            for (int i = sizeA / 2; i < sizeA; i++)
                C[i - sizeA / 2] = A[i];

            mergeSort(B, sizeA / 2, comparator);
            mergeSort(C, sizeA - sizeA / 2, comparator);
            merge(A, B, C, sizeA / 2, sizeA - sizeA / 2, comparator);
        }
    }

    private void merge(Contract[] A, Contract[] B, Contract[] C,
                       int sizeB, int sizeC, Comparator<Contract> comparator){
        int i = 0, j = 0, k = 0;
        while (i < sizeB && j < sizeC)
        {
            if (comparator.compare(C[j], B[i]) > 0)
            {
                A[k] = B[i];
                i++;
            }
            else
            {
                A[k] = C[j];
                j++;
            }
            k++;
        }
        if (i == sizeB)
            for (int t = j; t < sizeC; t++)
                A[k++] = C[t];
        else
            for (int t = i; t < sizeB; t++)
                A[k++] = B[t];
    }
}
