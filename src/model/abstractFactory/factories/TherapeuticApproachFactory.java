package model.abstractFactory.factories;

import model.abstractFactory.analyzer.Analyzer;

public interface TherapeuticApproachFactory {
    Analyzer getEmotionalAnalyzer();
    Analyzer getSymbolicAnalyzer();
    Analyzer getStatisticalAnalyzer();
    Analyzer getCognitiveAnalyzer();
}