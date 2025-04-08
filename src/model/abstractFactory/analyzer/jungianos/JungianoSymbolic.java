package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public class JungianoSymbolic extends SymbolicAnalyzer {
    public JungianoSymbolic() {
        this.approach = "Jungiano Symbolic";
    }

    @Override
    public String analyzeDream() {
        return ("Analizando el sueño desde una perspectiva jungiana-simbólica");
    }
}