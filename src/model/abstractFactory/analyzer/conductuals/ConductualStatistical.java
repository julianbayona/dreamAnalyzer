package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;

public class ConductualStatistical extends StatisticalAnalyzer {
    public ConductualStatistical() {
        this.approach = "Conductual Statistical";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva conductual-estadística");
        System.out.println("Analizando frecuencias y patrones de comportamiento");
    }
}