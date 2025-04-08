package model.abstractFactory.analyzer.abstracts;

import model.abstractFactory.analyzer.Analyzer;

public abstract class CognitiveAnalyzer implements Analyzer {
    protected String approach;

    protected CognitiveAnalyzer() {
        this.approach = "Cognitive";
    }

    @Override
    public String getApproach() {
        return this.approach;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}