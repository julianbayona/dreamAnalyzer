package model;

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
    public DreamReport withGraphicalInsights() {
        dreamReport.setGraphicalInsights("Representación gráfica generada.");
        return dreamReport;
    }

    @Override
    public DreamReport build() {
        return dreamReport;
    }

}
