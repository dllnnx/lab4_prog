package org.example.enums;

public enum Emotion {
    HAPPY("рад"),
    CALM("спокоен"),
    JEALOUS("завидует"),
    MISS("скучает"),
    ANXIETY("чувствует тревогу");

    private final String title;

    Emotion(String emotion){
        this.title = emotion;
    }
    public String getTitle() {
        return title;
    }

}
