package org.example.enums;

public enum Rate {
    BEST("лучший"),
    GOOD("хорош"),
    BAD("плох");
    private String title;

    Rate(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
