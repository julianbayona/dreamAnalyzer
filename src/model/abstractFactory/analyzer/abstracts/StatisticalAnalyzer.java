package model.abstractFactory.analyzer.abstracts;

import model.abstractFactory.analyzer.Analyzer;

public abstract class StatisticalAnalyzer implements Analyzer {
    protected String approach;

    protected StatisticalAnalyzer() {
        this.approach = "Statistical";
    }

    @Override
    public String getApproach() {
        return this.approach;
    }
}