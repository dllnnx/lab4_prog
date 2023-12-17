package org.example.actions;

import org.example.characters.*;
import org.example.enums.Emotion;
import org.example.enums.EventType;
import org.example.interfaces.Action;

public class PersonMissesSomeone implements Action {
    private final Human  malysh;

    public PersonMissesSomeone(Human malysh, Human karlson) {
        this.malysh = malysh;
        this.karlson = karlson;
    }

    private final Human karlson;

    @Override
    public void run() {
        Human.HumanMind malyshMind = malysh.new HumanMind();
        malyshMind.miss(karlson);
        karlson.addDescription("бодрый", "веселый");
        karlson.printDescription();
        malyshMind.remember(new Event(karlson, EventType.WAVE), new Event(karlson, EventType.TALKGOOD));

        malyshMind.think("Неужели Карлсон больше никогда не прилетит?");
        malysh.setEmotion(Emotion.ANXIETY);
        System.out.println(malysh.getName() + " " + malysh.getEmotion().getTitle() + ".");
    }

    @Override
    public String getState() {
        return "И вдруг Малыш почувствовал, что он очень соскучился по Карлсону -- бодрому, веселому человечку, " +
                "который так потешно махал своей маленькой рукой, приговаривая: " +
                "\"Неприятности -- это пустяки, дело житейское, и расстраиваться тут нечего\". " +
                "\"Неужели Карлсон больше никогда не прилетит?\" -- с тревогой подумал Малыш.";
    }
}
