package org.example.enums;

public enum Comparison {
    LIKEABEE("словно гигантский шмель"),
    LIKEAFLY("как маленькая муха"),
    LIKEATIGER("как тигр");
    private final String title;

    Comparison(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
