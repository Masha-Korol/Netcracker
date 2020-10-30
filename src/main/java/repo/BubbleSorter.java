package repo;

import model.Contract;

public class BubbleSorter implements ISorter {

    @Override
    public void sort(Contract[] contracts, String crit, int count) {
        for(int i = 0; i < count - 1; i++){
            for(int j = 0; j < count - i - 1; j++){
                if(compare(contracts[j], contracts[j + 1], crit)){
                    Contract contract = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = contract;
                }
            }
        }
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
}
