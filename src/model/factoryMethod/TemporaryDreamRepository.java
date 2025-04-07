package model.factoryMethod;



import model.Dream;

import java.util.ArrayList;

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
