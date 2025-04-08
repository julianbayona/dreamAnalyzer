package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;
import model.prototype.Dream;

public class JungianoSymbolic extends SymbolicAnalyzer {
    public JungianoSymbolic() {
        this.approach = "Jungiano Symbolic";
    }

    @Override
    public String analyzeDream() {
        return ("Sueño analizado desde una perspectiva jungiana-simbólica");
    }

    @Override
    public Dream analyzeDuplicatedDream(Dream dream) {
        Dream duplicatedDream = dream.clone();
        duplicatedDream.setNarrative("Sueño analizado desde una perspectiva jungiana-simbólica");
        return duplicatedDream;
    }
}