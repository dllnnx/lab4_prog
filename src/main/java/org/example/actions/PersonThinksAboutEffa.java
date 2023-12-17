package org.example.actions;

import org.example.characters.Human;
import org.example.interfaces.Action;

public class PersonThinksAboutEffa implements Action {

    private final Human malysh;

    public PersonThinksAboutEffa(Human malysh) {
        this.malysh = malysh;
    }

    @Override
    public void run() {
        Human.HumanMind malyshMind = malysh.new HumanMind();
        malyshMind.think("Если он завтра опять будет хвастаться Еффой, я ему расскажу про Карлсона. " +
                "Что стоит его Еффа по сравнению с Карлсоном, который живет на крыше! Так я ему и скажу");
    }

    @Override
    public String getState() {
        return "Если он завтра опять будет хвастаться Еффой, я ему расскажу про Карлсона. " +
                "Что стоит его Еффа по сравнению с Карлсоном, который живет на крыше! Так я ему и скажу.";
    }
}
