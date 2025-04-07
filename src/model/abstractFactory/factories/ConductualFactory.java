package model.abstractFactory.factories;

import model.abstractFactory.analyzer.Analyzer;
import model.abstractFactory.analyzer.conductuals.*;

public class ConductualFactory implements TherapeuticApproachFactory {
    @Override
    public Analyzer getEmotionalAnalyzer() {
        return new ConductualEmotional();
    }

    @Override
    public Analyzer getSymbolicAnalyzer() {
        return new ConductualSymbolic();
    }

    @Override
    public Analyzer getStatisticalAnalyzer() {
        return new ConductualStatistical();
    }

    @Override
    public Analyzer getCognitiveAnalyzer() {
        return new ConductualCognitive();
    }
}