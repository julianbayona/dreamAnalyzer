package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;

public class JungianoStatistical extends StatisticalAnalyzer {
    public JungianoStatistical() {
        this.approach = "Jungiano Statistical";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva jungiana-estadística");
        System.out.println("Evaluando patrones de arquetipos recurrentes");
    }
}