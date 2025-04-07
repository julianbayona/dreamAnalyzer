package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;

public class JungianoCognitive extends CognitiveAnalyzer {
    public JungianoCognitive() {
        this.approach = "Jungiano Cognitive";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva jungiana-cognitiva");
        System.out.println("Explorando la relación entre arquetipos y procesos cognitivos");
    }
}