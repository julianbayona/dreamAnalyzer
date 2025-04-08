package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;
import model.prototype.Dream;

public class JungianoCognitive extends CognitiveAnalyzer {
    public JungianoCognitive() {
        this.approach = "Jungiano Cognitive";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva jungiana-cognitiva");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva jungiana-cognitiva");
        return duplicatedDream;
    }

    
}