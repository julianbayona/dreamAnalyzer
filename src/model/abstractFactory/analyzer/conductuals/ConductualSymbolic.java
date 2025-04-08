package model.abstractFactory.analyzer.conductuals;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;
import model.prototype.Dream;

public class ConductualSymbolic extends SymbolicAnalyzer {
    public ConductualSymbolic() {
        this.approach = "Conductual Symbolic";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva conductual-simbólica");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva conductual-simbólica");
        return duplicatedDream;
    }
}