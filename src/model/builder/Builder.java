package model.builder;

import model.abstractFactory.analyzer.abstracts.CognitiveAnalyzer;
import model.abstractFactory.analyzer.abstracts.EmotionalAnalyzer;
import model.abstractFactory.analyzer.abstracts.StatisticalAnalyzer;
import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public interface Builder<T> {
    T withSummary();
    T withSymbolicSection(SymbolicAnalyzer symbolicAnalyzer);
    T withCognitiveSection(CognitiveAnalyzer cognitiveAnalyzer);
    T withEmotionalSection(EmotionalAnalyzer emotionalAnalyzer);
    T withStaticalSection(StatisticalAnalyzer statisticalAnalyzer);
    T withGraphicalInsights();
    T build();
}
