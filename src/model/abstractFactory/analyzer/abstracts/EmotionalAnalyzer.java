package model.abstractFactory.analyzer.abstracts;

import model.abstractFactory.analyzer.Analyzer;

public abstract class EmotionalAnalyzer implements Analyzer {
    protected String approach;

    protected EmotionalAnalyzer() {
        this.approach = "Emotional";
    }

    @Override
    public String getApproach() {
        return this.approach;
    }
}