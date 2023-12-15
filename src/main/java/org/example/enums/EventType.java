package org.example.enums;

public enum EventType {
    PLAY("играть", "хорошо"),
    BRAG("хвастаться", "плохо"),
    PAINT("рисовать", "хорошо"),
    CLEANUP("прибраться", "хорошо"),
    BEFRIEND("быть товарищем", "хорошо"),
    EVERYTHING("все в мире", "хорошо");
    private final String title;
    private final String rate;

    EventType(String title, String rate) {
        this.title = title;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public String getRate() {
        return rate;
    }
}
