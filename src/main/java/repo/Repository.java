package repo;

import model.*;

public class Repository {
    final int DEFAULT_CAPACITY = 16;

    int internetContractCount;
    int phoneContractCount;
    int tvContractCount;
    InternetContract[] internetContracts = new InternetContract[DEFAULT_CAPACITY];
    PhoneContract[] phoneContracts = new PhoneContract[DEFAULT_CAPACITY];
    TVContract[] tvContracts = new TVContract[DEFAULT_CAPACITY];

    /**
     * returns array of all internet contracts
     * @return InternetContract[]
     */
    public InternetContract[] getAllInternetContracts(){
        return internetContracts;
    }

    /**
     * returns array of all tv contracts
     * @return TVContract[]
     */
    public TVContract[] getAllTVContracts(){
        return tvContracts;
    }

    /**
     * returns array of all phone contracts
     * @return PhoneContract[]
     */
    public PhoneContract[] getAllPhoneContracts(){
        return phoneContracts;
    }

    /**
     * returns internet contract by id (first found)
     * @param id
     * @return InternetContract
     */
    public InternetContract getInternetContract(int id){
        try {
            for(InternetContract internetContract : internetContracts){
                if (internetContract.getId() == id){
                    return internetContract;
                }
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;
    }

    /**
     * returns phone contract by id (first found)
     * @param id
     * @return PhoneContract
     */
    public PhoneContract getPhoneContract(int id){
        try {
            for (PhoneContract phoneContract : phoneContracts){
                if(phoneContract.getId()==id){
                    return phoneContract;
                }
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;
    }

    /**
     * returns tv contract by id (first found)
     * @param id
     * @return TVContract
     */
    public TVContract getTVContract(int id){
        try{
            for (TVContract tvContract : tvContracts){
                if (tvContract.getId()==id){
                    return tvContract;
                }
            }
        } catch (NullPointerException e){
            return null;
        }
        return null;
    }

    /**
     * adds new internet contract
     * @param internetContract
     */
    public void addInternetContract(InternetContract internetContract){

        if(internetContractCount + 1 > internetContracts.length){
            InternetContract[] internetContracts_new = new InternetContract[internetContractCount*2];
            int i;
            for(i = 0; i < internetContractCount; i++){
                internetContracts_new[i] = internetContracts[i];
            }
            internetContracts_new[internetContractCount++] = internetContract;
            internetContracts=internetContracts_new;
        }

        internetContracts[internetContractCount++] = internetContract;
    }

    /**
     * adds new phone contract
     * @param phoneContract
     */
    public void  addPhoneContract(PhoneContract phoneContract){
        if(phoneContractCount + 1 > phoneContracts.length){
            PhoneContract[] phoneContracts_new = new PhoneContract[phoneContractCount*2];
            int i;
            for(i = 0; i<phoneContractCount; i++){
                phoneContracts_new[i] = phoneContracts[i];
            }
            phoneContracts_new[phoneContractCount++] = phoneContract;
            phoneContracts = phoneContracts_new;
        }

        phoneContracts[phoneContractCount++] = phoneContract;
    }

    /**
     * adds new tv contract
     * @param tvContract
     */
    public void addTVContract(TVContract tvContract){
        if(tvContractCount + 1 > tvContracts.length){
            TVContract[] tvContracts_new = new TVContract[tvContractCount*2];
            int i;
            for(i = 0;i < tvContractCount; i++){
                tvContracts_new[i] = tvContracts[i];
            }
            tvContracts_new[tvContractCount++] = tvContract;
            tvContracts = tvContracts_new;
        }

        tvContracts[tvContractCount++] = tvContract;
    }

    /**
     * deletes internet contract by id
     * @param id
     * @return boolean - deleted or not found
     */
    public boolean deleteInternetContract(int id){
        for (int i = 0; i < internetContractCount && internetContracts[i] != null; i++){
            if (internetContracts[i].getId() == id){
                internetContracts[i] = null;
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
        for (int i = 0; i < phoneContractCount && phoneContracts[i] != null; i++){
            if (phoneContracts[i].getId() == id){
                phoneContracts[i] = null;
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
        for (int i = 0; i < tvContractCount && tvContracts[i] != null; i++){
            if (tvContracts[i].getId() == id){
                tvContracts[i] = null;
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
    public boolean replaceInternetContract(int id, InternetContract internetContract){
        for (int i =0;i < internetContractCount && internetContracts[i] != null; i++){
            if (internetContracts[i].getId() == id){
                internetContracts[i] = internetContract;
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
    public boolean replacePhoneContract(int id, PhoneContract phoneContract){
        for (int i =0;i < phoneContractCount && phoneContracts[i] != null; i++){
            if (phoneContracts[i].getId() == id){
                phoneContracts[i] = phoneContract;
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
    public boolean replaceTVContract(int id, TVContract tvContract){
        for (int i =0;i < tvContractCount && tvContracts[i] != null; i++){
            if (tvContracts[i].getId() == id){
                tvContracts[i] = tvContract;
                return true;
            }
        }
        return false;
    }
}
