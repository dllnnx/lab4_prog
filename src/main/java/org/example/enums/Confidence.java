package org.example.enums;

public enum Confidence {
    DEFINITELY("уверен, что"),
    PROBABLY("почти уверен, что"),
    DEFINITELYNOT("не уверен, что");
    private final String title;

    Confidence(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
