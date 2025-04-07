package model.factoryMethod;

public abstract class AbstractRepositoryFactory {

    public abstract AbstractProductRepository create(String type);

}
