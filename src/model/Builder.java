package model;

public interface Builder<T> {
    T withSummary();
    T withSymbolicSection(SymbolicAnalyzer symbolicAnalyzer);
    T withGraphicalInsights();
    T build();
}
