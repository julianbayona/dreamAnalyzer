package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public class ConductualSymbolic extends SymbolicAnalyzer {
    public ConductualSymbolic() {
        this.approach = "Conductual Symbolic";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva conductual-simbólica");
        System.out.println("Evaluando símbolos como estímulos condicionados");
    }
}