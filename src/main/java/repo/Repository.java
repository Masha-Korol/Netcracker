package repo;

import model.*;

public class Repository {
    final int DEFAULT_CAPACITY = 16;
    private int count;
    private ISorter sorter = new BubbleSorter();
    Contract[] contracts = new Contract[DEFAULT_CAPACITY];

    /**
     * sorts array of contracts, using injected type of sort
     * @param crit
     */
    public void sort(String crit){
        sorter.sort(contracts, crit, count);
    }

    private boolean compare(String crit, Contract contract, Object par){
        switch (crit){
            case "id":
                return contract.getId().equals(par);
            case "start":
                return contract.getStart().equals(par);
            case "finish":
                return contract.getFinish().equals(par);
            case "user":
                return contract.getUser().equals(par);
            default:
                return false;
        }
    }

    /**
     * gets all contracts by criteria
     * @param crit - criteria (property of entity)
     * @param par - value by which contracts will be chosen
     * @return array of contracts
     */
    public Contract[] getContracts(String crit, Object par){
        Contract[] result = new Contract[count];
        int size = 0;
        for (int i = 0; i < count; i++){
            if (compare(crit, contracts[i], par)){
                result[size++] = contracts[i];
            }
        }
        return result;
    }

    /**
     * gets all contracts
     * @return
     */
    public Contract[] getAllContracts(){
        return contracts;
    }

    /**
     * returns internet contract by id (first found)
     * @param id
     * @return Contract
     */
    public Contract getContract(int id){
        for(int i = 0; i < count; i++){
            if (contracts[i].getId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * adds new contract
     * @param contract
     */
    public void addContract(Contract contract) {

        if (count + 1 > contracts.length) {
            enlarge();
        }
        contracts[count++] = contract;
    }

    /**
     * adds array of contracts
     * @param array
     */
    public void addContracts(Contract[] array){
        while (count + array.length > contracts.length){
            enlarge();
        }
        for (int i = 0; i < array.length; i++){
            contracts[count++] = array[i];
        }
    }

    /**
     * makes array twice bigger
     */
    private void enlarge(){
        Contract[] array_new = new Contract[count * 2];
        for (int i = 0; i < count; i++){
            array_new[i] = contracts[i];
        }
        contracts = array_new;
    }

    /**
     * puts all null entities in the end of array
     */
    private void trimArray(){
        Contract[] contracts_new = new Contract[contracts.length];
        int size = 0;
        for (int i = 0; i < contracts.length - 1; i++){
            if (contracts[i] != null){
                contracts_new[size++] = contracts[i];
            }
        }
        contracts = contracts_new;
    }

    /**
     * deletes contract by id
     * @param id
     * @return
     */
    public boolean deleteContract(int id){
        for (int i = 0; i < count; i--){
            if(contracts[i].getId() == id){
                contracts[i] = null;
                trimArray();
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * replaces contract, found by id, with new one
     * @param id id of contract to replace
     * @param contract contract with which replace
     * @return boolean - replaced or not found
     */
    public boolean replaceContract(int id, Contract contract){
        for (int i=0;i<count;i++){
            if(contracts[i].getId()==id){
                contracts[i]=contract;
                return true;
            }
        }
        return false;
    }
}
