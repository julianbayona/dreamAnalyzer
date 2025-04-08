package model.factoryMethod;

import java.util.ArrayList;

import model.prototype.Dream;

public class HistoricalDreamRepository extends AbstractProductRepository {

    public HistoricalDreamRepository() {
        dreams = new ArrayList<Dream>();
    }


    @Override
    public void saveDream(Dream dream) {
        this.dreams.add(dream);

    }


    @Override
    public Dream getDream(int id) {
        return dreams.get(id);
    }

}

