package factory;

import model.Contract;

public abstract class Factory {
    public abstract Contract createContract(int id);
}

