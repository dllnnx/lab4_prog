package org.example.enums;

public enum Measure {
    PASSIONATELY("страстно"),
    ABIT("немного"),
    REALLY("очень"),
    NOTATALL("совсем не");

    Measure(String title) {
        this.title = title;
    }

    private final String title;

    public String getTitle() {
        return title;
    }
}
