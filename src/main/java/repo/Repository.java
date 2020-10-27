package repo;

import model.*;

public class Repository {
    final int DEFAULT_CAPACITY = 16;

    private int countInternetContracts;
    private int countPhoneContracts;
    private int countTVContracts;
    private int count;
    Contract[] contracts = new Contract[DEFAULT_CAPACITY];

    /**
     * gets all contracts
     * @return
     */
    public Contract[] getAllContracts(){
        return contracts;
    }

    /**
     * returns array of all internet contracts
     * @return InternetContract[]
     */
    public Contract[] getAllInternetContracts(){
        Contract[] contracts = new Contract[countInternetContracts];
        int count = 0;
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof InternetContract){
                contracts[count++] = contracts[i];
            }
        }
        return contracts;
    }

    /**
     * returns array of all tv contracts
     * @return TVContract[]
     */
    public Contract[] getAllTVContracts(){
        Contract[] contracts = new Contract[countTVContracts];
        int count = 0;
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof TVContract){
                contracts[count++] = contracts[i];
            }
        }
        return contracts;
    }

    /**
     * returns array of all phone contracts
     * @return PhoneContract[]
     */
    public Contract[] getAllPhoneContracts(){
        Contract[] contracts = new Contract[countPhoneContracts];
        int count = 0;
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof PhoneContract){
                contracts[count++] = contracts[i];
            }
        }
        return contracts;
    }

    /**
     * returns internet contract by id (first found)
     * @param id
     * @return InternetContract
     */
    public Contract getInternetContract(int id){
        for (int i = 0; i < count; i++){
            if ((contracts[i] instanceof InternetContract) &&
                    ((InternetContract)contracts[i]).getId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * returns phone contract by id (first found)
     * @param id
     * @return PhoneContract
     */
    public Contract getPhoneContract(int id){
        for (int i = 0; i < count; i++){
            if ((contracts[i] instanceof PhoneContract) &&
                    ((PhoneContract)contracts[i]).getId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * returns tv contract by id (first found)
     * @param id
     * @return TVContract
     */
    public Contract getTVContract(int id){
        for (int i = 0; i < count; i++){
            if ((contracts[i] instanceof TVContract) &&
                    ((TVContract)contracts[i]).getId() == id){
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

        if (contract instanceof InternetContract){
            countInternetContracts++;
        }
        else if (contract instanceof PhoneContract) {
            countPhoneContracts++;
        }
        else {
            countTVContracts++;
        }
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

        if (array instanceof InternetContract[]){
            countInternetContracts += array.length;
        }
        else if (array instanceof PhoneContract[]){
            countPhoneContracts += array.length;
        }
        else {
            countTVContracts += array.length;
        }
    }

    /**
     * makes array twice bigger
     */
    public void enlarge(){
        Contract[] array_new = new Contract[count * 2];
        for (int i = 0; i < count; i++){
            array_new[i] = contracts[i];
        }
        contracts = array_new;
    }

    /**
     * puts all null entities in the end of array
     */
    public void trimArray(){
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
     * deletes internet contract by id
     * @param id
     * @return boolean - deleted or not found
     */
    public boolean deleteInternetContract(int id){
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof InternetContract &&
                    ((InternetContract)contracts[i]).getId() == id){
                contracts[i] = null;
                trimArray();
                countInternetContracts--;
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * deletes phone contract by id
     * @param id
     * @return boolean - deleted or not found
     */
    public boolean deletePhoneContract(int id){
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof PhoneContract &&
                    ((PhoneContract)contracts[i]).getId() == id){
                contracts[i] = null;
                trimArray();
                countPhoneContracts--;
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * deletes tv contract by id
     * @param id
     * @return boolean - deleted or not found
     */
    public boolean deleteTVContract(int id){
        for (int i = 0; i < count; i++){
            if (contracts[i] instanceof TVContract &&
                    ((TVContract)contracts[i]).getId() == id){
                contracts[i] = null;
                trimArray();
                countTVContracts--;
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * replaces contract, found by id, with new one
     * @param id id of contract to replace
     * @param internetContract contract with which replace
     * @return boolean - replaced or not found
     */
    public boolean replaceInternetContract(int id, Contract internetContract){
        for (int i =0; i < count; i++){
            if (contracts[i] instanceof InternetContract &&
                    ((InternetContract)contracts[i]).getId() == id){
                contracts[i] = internetContract;
                return true;
            }
        }
        return false;
    }

    /**
     * replaces contract, found by id, with new one
     * @param id id of contract to replace
     * @param phoneContract contract with which replace
     * @return boolean - replaced or not found
     */
    public boolean replacePhoneContract(int id, Contract phoneContract){
        for (int i =0; i < count; i++){
            if (contracts[i] instanceof PhoneContract &&
                    ((PhoneContract)contracts[i]).getId() == id){
                contracts[i] = phoneContract;
                return true;
            }
        }
        return false;
    }

    /**
     * replaces contract, found by id, with new one
     * @param id id of contract to replace
     * @param tvContract contract with which replace
     * @return boolean - replaced or not found
     */
    public boolean replaceTVContract(int id, Contract tvContract){
        for (int i =0; i < count; i++){
            if (contracts[i] instanceof TVContract &&
                    ((TVContract)contracts[i]).getId() == id){
                contracts[i] = tvContract;
                return true;
            }
        }
        return false;
    }
}
