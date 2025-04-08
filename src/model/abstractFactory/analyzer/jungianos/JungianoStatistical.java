package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;

public class JungianoStatistical extends StatisticalAnalyzer {
    public JungianoStatistical() {
        this.approach = "Jungiano Statistical";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva jungiana-estadística");
    }
}