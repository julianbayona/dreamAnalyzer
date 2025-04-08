package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;

public class JungianoEmotional extends EmotionalAnalyzer {
    public JungianoEmotional() {
        this.approach = "Jungiano Emotional";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva jungiana-emocional");
    }
}