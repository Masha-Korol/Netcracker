package repo;

import model.Contract;

public class MergeSorter implements ISorter {
    @Override
    public void sort(Contract[] contracts, String crit, int count) {
        mergeSort(contracts, count, crit);
    }

    private boolean compare(Contract contract1, Contract contract2, String crit){
        switch (crit) {
            case "id":
                return contract1.getId() > contract2.getId();
            case "start":
                return contract1.getStart().compareTo(contract2.getStart()) > 0;
            case "finish":
                return contract1.getFinish().compareTo(contract2.getFinish()) > 0;
            case "user":
                return contract1.getUser().getId() > contract2.getUser().getId();
            default:
                return false;
        }
    }

    private void mergeSort(Contract[] A, int sizeA, String crit){
        if (sizeA > 1){
            Contract[] B = new Contract[sizeA / 2];
            Contract[] C = new Contract[sizeA - sizeA / 2];

            for (int i = 0; i < sizeA / 2; i++)
                B[i] = A[i];
            for (int i = sizeA / 2; i < sizeA; i++)
                C[i - sizeA / 2] = A[i];

            mergeSort(B, sizeA / 2, crit);
            mergeSort(C, sizeA - sizeA / 2, crit);
            merge(A, B, C, sizeA / 2, sizeA - sizeA / 2, crit);
        }
    }

    private void merge(Contract[] A, Contract[] B, Contract[] C,
                       int sizeB, int sizeC, String crit){
        int i = 0, j = 0, k = 0;
        while (i < sizeB && j < sizeC)
        {
            if (compare(C[j], B[i], crit))
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
