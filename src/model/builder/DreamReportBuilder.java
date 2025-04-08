package model.builder;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;
import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;
import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;
import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public class DreamReportBuilder implements Builder<DreamReport> {

    DreamReport dreamReport;

    public DreamReportBuilder() {
        this.dreamReport = new DreamReport();
    }

    @Override
    public DreamReport withSummary() {
        dreamReport.setSummary("Este es un resumen del reporte de sueños.");
        return dreamReport;
    }

    @Override
    public DreamReport withSymbolicSection(SymbolicAnalyzer symbolicAnalyzer) {
        dreamReport.setAnalyzer(symbolicAnalyzer);
        return dreamReport;
    }

    @Override
    public DreamReport withCognitiveSection(CognitiveAnalyzer cognitiveAnalyzer) {
        dreamReport.setAnalyzer(cognitiveAnalyzer);
        return dreamReport;
    }

    @Override
    public DreamReport withEmotionalSection(EmotionalAnalyzer emotionalAnalyzer) {
        dreamReport.setAnalyzer(emotionalAnalyzer);
        return dreamReport;
    }

    @Override
    public DreamReport withStaticalSection(StatisticalAnalyzer statisticalAnalyzer) {
        dreamReport.setAnalyzer(statisticalAnalyzer);
        return dreamReport;
    }

    @Override
    public DreamReport withGraphicalInsights() {
        dreamReport.setGraphicalInsights("Representación gráfica generada.");
        return dreamReport;
    }

    @Override
    public DreamReport build() {
        return dreamReport;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DreamReportBuilder{");
        sb.append("dreamReport=").append(dreamReport);
        sb.append('}');
        return sb.toString();
    }



}
