package org.example.enums;

public enum HeadMovement {
    BOW("склоняет голову"),
    SHAKE("качает головой"),
    NOD("кивает головой"),
    TURN("поворачивает головой");
    private final String title;

    HeadMovement(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
