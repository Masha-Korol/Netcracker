package repo;

import annotation.Inject;
import db.DataParser;
import model.*;
import sorter.BubbleSorter;
import sorter.ISorter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * contains contracts and methods for its management
 */
@XmlRootElement(name = "repository")
@XmlType(propOrder = {"contracts"})
public class Repository {
    final int DEFAULT_CAPACITY = 16;
    private int count;
    @Inject
    private ISorter sorter;
    private Contract[] contracts = new Contract[DEFAULT_CAPACITY];
    private DataParser dataParser;

    /*public Repository(DataParser dataParser) {
        this.dataParser = dataParser;
    }*/

    /*public void saveExistingContractsToDb(){
        dataParser.addContracts(this.contracts);
    }*/

    public void setContracts(Contract[] contracts) {
        this.contracts = contracts;
    }

    /**
     * sorts array of contracts, using injected type of sort
     *
     * @param comparator
     */
    public void sort(Comparator<Contract> comparator) {
        sorter.sort(contracts, comparator);
    }

    /**
     * gets all contracts by criteria
     *
     * @param predicate
     * @return array of contracts
     */
    public Repository getContracts(Predicate<Contract> predicate) {
        Repository repository = new Repository();

        for (int i = 0; i < count; i++) {
            if (predicate.test(contracts[i])) {
                repository.addContract(contracts[i]);
            }
        }
        return repository;
    }

    /**
     * gets all contracts
     *
     * @return array of contracts
     */
    public Contract[] getAllContracts() {
        return this.contracts;
    }

    /**
     * returns internet contract by id (first found)
     *
     * @param id
     * @return Contract
     */
    public Contract getContract(int id) {
        for (int i = 0; i < count; i++) {
            if (contracts[i].getId() == id) {
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * adds new contract
     *
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
     *
     * @param array
     */
    public void addContracts(Contract[] array) {
        while (count + array.length > contracts.length) {
            enlarge();
        }
        for (int i = 0; i < array.length; i++) {
            contracts[count++] = array[i];
        }
    }

    /**
     * makes array twice bigger
     */
    private void enlarge() {
        Contract[] arrayNew = new Contract[count * 2];
        for (int i = 0; i < count; i++) {
            arrayNew[i] = contracts[i];
        }
        contracts = arrayNew;
    }

    /**
     * puts all null entities in the end of array
     */
    private void trimArray() {
        Contract[] contractsNew = new Contract[contracts.length];
        int size = 0;
        for (int i = 0; i < contracts.length - 1; i++) {
            if (contracts[i] != null) {
                contractsNew[size++] = contracts[i];
            }
        }
        contracts = contractsNew;
    }

    /**
     * deletes contract by id
     *
     * @param id
     * @return
     */
    public boolean deleteContract(int id) {
        for (int i = 0; i < count; i--) {
            if (contracts[i].getId() == id) {
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
     *
     * @param id       id of contract to replace
     * @param contract contract with which replace
     * @return boolean - replaced or not found
     */
    public boolean replaceContract(int id, Contract contract) {
        for (int i = 0; i < count; i++) {
            if (contracts[i].getId() == id) {
                contracts[i] = contract;
                return true;
            }
        }
        return false;
    }

    public Contract[] getContracts() {
        return contracts;
    }
}
