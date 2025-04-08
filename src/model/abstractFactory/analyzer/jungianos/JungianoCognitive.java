package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;

public class JungianoCognitive extends CognitiveAnalyzer {
    public JungianoCognitive() {
        this.approach = "Jungiano Cognitive";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva jungiana-cognitiva");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}