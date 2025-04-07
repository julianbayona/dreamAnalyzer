package model.abstractFactory.analyzer.jungianos;

import model.abstractFactory.analyzer.abstracts.SymbolicAnalyzer;

public class JungianoSymbolic extends SymbolicAnalyzer {
    public JungianoSymbolic() {
        this.approach = "Jungiano Symbolic";
    }

    @Override
    public void analyzeDream() {
        System.out.println("Analizando el sueño desde una perspectiva jungiana-simbólica");
        System.out.println("Interpretando símbolos arquetípicos y su significado colectivo");
    }
}