package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;
import org.example.interfaces.Action;

public class PersonThinksAboutTheDay implements Action {
    private final Human malysh;
    private final Day day;

    public PersonThinksAboutTheDay(Human malysh, Day day) {
        this.malysh = malysh;
        this.day = day;
    }

    @Override
    public void run() {
        Opinion.OpinionAboutEvent.addOpinion(malysh,
                new Opinion.OpinionAboutEvent(new Event(day, EventType.TOPSYTORVY), Characterization.BAD));
    }

    @Override
    public String getState() {
        return "Да, ничего хорошего нельзя было ожидать в такой неудачный день, когда буквально все шло шиворот-навыворот.";
    }
}
