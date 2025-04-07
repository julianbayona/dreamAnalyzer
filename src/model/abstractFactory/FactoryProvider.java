package model.abstractFactory;

import model.abstractFactory.factories.ConductualFactory;
import model.abstractFactory.factories.JungianoFactory;
import model.abstractFactory.factories.TherapeuticApproachFactory;

public class FactoryProvider {
    public TherapeuticApproachFactory getFactory(String type) {
        switch (type) {
            case Constants.JUNGIANO:
                return new JungianoFactory();
            case Constants.CONDUCTUAL:
                return new ConductualFactory();
            default:
                return null;
        }
    }
}
