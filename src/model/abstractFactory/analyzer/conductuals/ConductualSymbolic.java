package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public class ConductualSymbolic extends SymbolicAnalyzer {
    public ConductualSymbolic() {
        this.approach = "Conductual Symbolic";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva conductual-simbólica");
    }
}