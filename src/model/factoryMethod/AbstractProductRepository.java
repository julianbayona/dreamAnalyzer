package model.factoryMethod;

import model.Dream;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProductRepository {
    protected List<Dream> dreams = new ArrayList<>();

    public abstract void saveDream(Dream dream);
    public abstract Dream getDream(int id);
}

