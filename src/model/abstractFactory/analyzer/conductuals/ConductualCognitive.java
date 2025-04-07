package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;

public class ConductualCognitive extends CognitiveAnalyzer {
    public ConductualCognitive() {
        this.approach = "Conductual Cognitive";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva conductual-cognitiva");
        System.out.println("Examinando esquemas mentales y patrones de pensamiento");
    }
}