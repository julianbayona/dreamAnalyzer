package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;

public class ConductualStatistical extends StatisticalAnalyzer {
    public ConductualStatistical() {
        this.approach = "Conductual Statistical";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva conductual-estadística");
    }
}