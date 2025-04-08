package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;
import model.prototype.Dream;

public class JungianoEmotional extends EmotionalAnalyzer {
    public JungianoEmotional() {
        this.approach = "Jungiano Emotional";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva jungiana-emocional");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva jungiana-emocional");
        return duplicatedDream;
    }
}