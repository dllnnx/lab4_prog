package org.example.enums;

public enum Count {
    MANY("много"),
    FEW("несколько"),
    ALITTLE("мало");
    private final String title;

    Count(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
