package model.builder;

import model.abstractFactory.analyzer.Analyzer;

public class DreamReport {

    private Analyzer analyzer;
    private String content;
    private String summary;
    private String graphicalInsights;

    public DreamReport() {
        this.content = "";
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        content += analyzer.analyzeDream() + "\n";
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

    @Override
    public String toString() {
        return "DreamReport{"
                + ", content='" + content + '\''
                + ", summary='" + summary + '\''
                + ", graphicalInsights='" + graphicalInsights + '\''
                + '}';
    }
}
