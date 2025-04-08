package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;

public class ConductualCognitive extends CognitiveAnalyzer {
    public ConductualCognitive() {
        this.approach = "Conductual Cognitive";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva conductual-cognitiva");
    }
}