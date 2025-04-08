package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;
import model.prototype.Dream;

public class ConductualEmotional extends EmotionalAnalyzer {
    public ConductualEmotional() {
        this.approach = "Conductual Emotional";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva conductual-emocional");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva conductual-emocional");
        return duplicatedDream;
    }
}