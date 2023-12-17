package org.example.enums;

public enum Characterization {
    BAD("плохо"),
    GOOD("хорошо"),
    OK("нормально");
    private final String title;

    Characterization(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
