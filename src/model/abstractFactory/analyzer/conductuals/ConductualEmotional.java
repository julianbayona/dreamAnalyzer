package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;

public class ConductualEmotional extends EmotionalAnalyzer {
    public ConductualEmotional() {
        this.approach = "Conductual Emotional";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva conductual-emocional");
        System.out.println("Identificando patrones emocionales y respuestas conductuales");
    }
}