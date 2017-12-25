package com.tex2e;

import javafx.beans.property.SimpleStringProperty;

public class Word {
    private final SimpleStringProperty word = new SimpleStringProperty("");
    private final SimpleStringProperty definition = new SimpleStringProperty("");

    public Word() {
        this("", "");
    }

    public Word(String word, String definition) {
        setWord(word);
        setDefinition(definition);
    }

    public String getWord() {
        return this.word.get();
    }

    public void setWord(String word) {
        this.word.set(word);
    }

    public String getDefinition() {
        return this.definition.get();
    }

    public void setDefinition(String definition) {
        this.definition.set(definition);
    }
}
