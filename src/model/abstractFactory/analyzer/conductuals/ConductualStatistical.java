package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;
import model.prototype.Dream;

public class ConductualStatistical extends StatisticalAnalyzer {
    public ConductualStatistical() {
        this.approach = "Conductual Statistical";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva conductual-estadística");
    }
    
    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva conductual-estadística");
        return duplicatedDream;
    }
}