package model.factoryMethod;



import java.util.ArrayList;

import model.prototype.Dream;

public class TemporaryDreamRepository extends AbstractProductRepository{

    public TemporaryDreamRepository() {
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
