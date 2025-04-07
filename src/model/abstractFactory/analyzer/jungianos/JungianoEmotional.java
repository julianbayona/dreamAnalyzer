package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;

public class JungianoEmotional extends EmotionalAnalyzer {
    public JungianoEmotional() {
        this.approach = "Jungiano Emotional";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva jungiana-emocional");
        System.out.println("Explorando arquetipos emocionales en el inconsciente colectivo");
    }
}