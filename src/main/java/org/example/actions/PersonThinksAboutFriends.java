package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;
import org.example.interfaces.Action;

public class PersonThinksAboutFriends implements Action {

    private final Human malysh, krister, gunilla, karlson;

    public PersonThinksAboutFriends(Human malysh, Human krister, Human gunilla, Human karlson) {
        this.malysh = malysh;
        this.krister = krister;
        this.gunilla = gunilla;
        this.karlson = karlson;
    }

    @Override
    public void run() {
        Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING));
        Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY));
        Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND));
        Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND));
        krister.brag("собакой Еффой", malysh);
    }

    @Override
    public String getState() {
        return "Малыш не сомневался, что Карлсон во всем \"лучший в мире\". " +
                "И уж наверняка он самый лучший в мире товарищ по играм. В этом Малыш убедился на собственном опыте... " +
                "Правда, Кристер, и Гунилла тоже хорошие товарищи, но им далеко до Карлсона, который живет на крыше! " +
                "Кристер только и делает, что хвалится своей собакой Еффой, и Малыш ему давнозавидует.";
    }
}
