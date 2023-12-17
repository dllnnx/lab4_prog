package org.example.actions;

import org.example.characters.Event;
import org.example.characters.Human;
import org.example.characters.Opinion;
import org.example.enums.Characterization;
import org.example.enums.Confidence;
import org.example.enums.EventType;
import org.example.enums.Rate;
import org.example.interfaces.Action;

public class PersonBeingSad implements Action {

    private final Human malysh;
    private final Human karlson;
    private final Human mom;

    public PersonBeingSad(Human malysh, Human karlson, Human mom) {
        this.malysh = malysh;
        this.karlson = karlson;
        this.mom = mom;
    }

    @Override
    public void run() {
        malysh.beSilent();
        Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.STEAMENGINE));
        Opinion.OpinionAboutEvent.addOpinion(malysh, new Opinion.OpinionAboutEvent(new Event(mom, EventType.SPANK),
                Characterization.BAD));
    }

    @Override
    public String getState() {
        return "Малыш ничего не ответил." +
                "Ему показалось ужасным, что мама собирается отшлепать лучшего в мире специалиста по паровым машинам.";
    }
}
