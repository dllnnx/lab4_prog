package org.example.actions;

import org.example.characters.Human;
import org.example.enums.HeadMovement;
import org.example.interfaces.Action;

public class PersonWantsToShowSomeone implements Action {
    private final Human thinkingPerson;

    public PersonWantsToShowSomeone(Human thinkingPerson) {
        this.thinkingPerson = thinkingPerson;
    }

    @Override
    public void run() {
        Human.HumanMind thinkingPersonMind = thinkingPerson.new HumanMind();
        thinkingPerson.moveHead(HeadMovement.SHAKE);
        thinkingPersonMind.rememberAboutObject("паровая машина");
        thinkingPersonMind.think("Вот сейчас, когда Карлсон здесь, мама и папа смогут убедиться, что он в самом деле существует");
        thinkingPerson.doWithCondition("Боссе и Бетан дома", "покажет Карлсона");
    }

    @Override
    public String getState() {
        return "Малыш покачал головой. Он вспомнил о своей паровой машине и подумал:" +
                " \"Вот сейчас, когда Карлсон здесь, мама и папа смогут убедиться, что он в самом деле существует\"." +
                " А если Боссе и Бетан дома, то им он тоже покажет Карлсона.";
    }
}
