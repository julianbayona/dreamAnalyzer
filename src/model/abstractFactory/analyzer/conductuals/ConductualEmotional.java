package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;

public class ConductualEmotional extends EmotionalAnalyzer {
    public ConductualEmotional() {
        this.approach = "Conductual Emotional";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva conductual-emocional");
    }
}