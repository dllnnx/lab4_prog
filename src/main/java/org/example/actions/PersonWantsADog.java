package org.example.actions;

import org.example.characters.Human;
import org.example.characters.Wish;
import org.example.enums.Measure;
import org.example.interfaces.Action;

import java.util.List;

public class PersonWantsADog implements Action {
    private final Human thinkingPerson;
    private final Human interruptingPerson;

    public PersonWantsADog(Human thinkingPerson, Human interruptingPerson) {
        this.thinkingPerson = thinkingPerson;
        this.interruptingPerson = interruptingPerson;
    }

    @Override
    public void run() {
        Wish.addWishes(new Wish("собаку", thinkingPerson, Measure.PASSIONATELY));
        interruptingPerson.interrupt(thinkingPerson);
    }

    @Override
    public String getState() {
        return "Малыш так страстно не желал иметь, как собаку... Карлсон прервал размышления Малыша.";
    }
}
