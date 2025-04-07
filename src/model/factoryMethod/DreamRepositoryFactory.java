package model.factoryMethod;


public class DreamRepositoryFactory extends AbstractRepositoryFactory{

    public DreamRepositoryFactory(){

    }

    @Override
    public  AbstractProductRepository create(String type) {
        switch (type) {
            case "historical":
                return new HistoricalDreamRepository();
            case "temporary":
                return new TemporaryDreamRepository();
            default:
                throw new IllegalArgumentException("Invalid repository type: " + type);
        }
    }
}
