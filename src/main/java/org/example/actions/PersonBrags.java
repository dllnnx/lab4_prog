package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;

public class PersonBrags implements Action{
    private final Human malysh;
    private final Human gunilla;
    private final Human krister;

    public PersonBrags(Human malysh, Human gunilla, Human krister) {
        this.malysh = malysh;
        this.gunilla = gunilla;
        this.krister = krister;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND));

        krister.brag("собакой Еффой", malysh);
    }

    @Override
    public String getState() {
        return "Кристер только и делает, что хвалится своей собакой Еффой, и Малыш ему давно завидует.";
    }
}
