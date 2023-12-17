package org.example.enums;

public enum Position {
    STAND("стоит"),
    LIE("лежит"),
    SIT("сидит"),
    UP("встал"),
    DOWN("сел"),
    READ("читает");
    private final String title;
    Position(String title) {
        this.title = title;
    }

    public String getTitle(){ return title; }
}
