package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;
import model.prototype.Dream;

public class ConductualCognitive extends CognitiveAnalyzer {
    public ConductualCognitive() {
        this.approach = "Conductual Cognitive";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva conductual-cognitiva");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva conductual-cognitiva");
        return duplicatedDream;
    }
}