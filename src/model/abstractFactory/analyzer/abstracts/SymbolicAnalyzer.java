package model.abstractFactory.analyzer.abstracts;

import model.abstractFactory.analyzer.Analyzer;

public abstract class SymbolicAnalyzer implements Analyzer {
    protected String approach;

    protected SymbolicAnalyzer() {
        this.approach = "Symbolic";
    }

    @Override
    public String getApproach() {
        return this.approach;
    }
}