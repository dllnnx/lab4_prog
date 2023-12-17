package org.example.enums;

public enum EventType {
    PLAY("играть", "хорошо"),
    BRAG("хвастаться", "плохо"),
    PAINT("рисовать", "хорошо"),
    CLEANUP("прибраться", "хорошо"),
    BEFRIEND("быть товарищем", "хорошо"),
    EVERYTHING("все в мире", "хорошо"),
    STEAMENGINE("паровые машины", "хорошо"),
    SPANK("хочет отшлепать Карлсона", "плохо"),
    TOPSYTORVY("идет шиворот-навыворот", "плохо"),
    WAVE("машет рукой", "хорошо"),
    TALKGOOD("говорит: \"Неприятности -- это пустяки, дело житейское, и расстраиваться тут нечего\"", "хорошо");
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
