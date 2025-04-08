package model.factoryMethod;

import java.util.ArrayList;
import java.util.List;

import model.prototype.Dream;

public abstract class AbstractProductRepository {
    protected List<Dream> dreams = new ArrayList<>();

    public abstract void saveDream(Dream dream);
    public abstract Dream getDream(int id);
}

