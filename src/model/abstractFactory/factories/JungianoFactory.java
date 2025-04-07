package model.abstractFactory.factories;

import model.abstractFactory.analyzer.Analyzer;
import model.abstractFactory.analyzer.jungianos.*;

public class JungianoFactory implements TherapeuticApproachFactory {
    @Override
    public Analyzer getEmotionalAnalyzer() {
        return new JungianoEmotional();
    }

    @Override
    public Analyzer getSymbolicAnalyzer() {
        return new JungianoSymbolic();
    }

    @Override
    public Analyzer getStatisticalAnalyzer() {
        return new JungianoStatistical();
    }

    @Override
    public Analyzer getCognitiveAnalyzer() {
        return new JungianoCognitive();
    }
}