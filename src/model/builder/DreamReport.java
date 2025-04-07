package model.builder;

import model.abstractFactory.analyzer.Analyzer;

public class DreamReport {
    private Analyzer analyzer;
    private String summary;
    private String graphicalInsights;

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGraphicalInsights() {
        return graphicalInsights;
    }

    public void setGraphicalInsights(String graphicalInsights) {
        this.graphicalInsights = graphicalInsights;
    }

}
