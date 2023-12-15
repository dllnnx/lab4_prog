package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;

public class PersonIsConfident implements Action{

    private final Human malysh;
    private final Human karlson;

    public PersonIsConfident(Human malysh, Human karlson) {
        this.malysh = malysh;
        this.karlson = karlson;
    }

    @Override
    public void run() {
        Opinion.addOpinion(malysh, new Opinion(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING));
    }

    @Override
    public String getState() {
        return "Малыш не сомневался, что Карлсон во всем \"лучший в мире\"";
    }
}
