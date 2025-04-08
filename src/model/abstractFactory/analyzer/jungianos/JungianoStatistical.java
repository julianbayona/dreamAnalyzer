package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;
import model.prototype.Dream;

public class JungianoStatistical extends StatisticalAnalyzer {
    public JungianoStatistical() {
        this.approach = "Jungiano Statistical";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva jungiana-estadística");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva jungiana-estadística");
        return duplicatedDream;
    }
}