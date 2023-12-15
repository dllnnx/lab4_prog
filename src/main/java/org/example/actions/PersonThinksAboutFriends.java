package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;

public class PersonThinksAboutFriends implements Action{

    private final Human malysh;
    private final Human krister;

    public PersonThinksAboutFriends(Human malysh, Human krister) {
        this.malysh = malysh;
        this.krister = krister;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND));
    }

    @Override
    public String getState() {
        return "Правда, Кристер, и Гунилла тоже хорошие товарищи, но им далеко до Карлсона, который живет на крыше!";
    }
}
