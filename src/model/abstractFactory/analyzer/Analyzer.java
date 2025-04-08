package model.abstractFactory.analyzer;

import model.prototype.Dream;

public interface Analyzer {
    String analyzeDream();
    Dream analyzeDuplicatedDream(Dream dream);
    String getApproach();
}