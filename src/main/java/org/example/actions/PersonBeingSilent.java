package org.example.actions;

import org.example.characters.Human;

public class PersonBeingSilent implements Action{

    private final Human malysh;

    public PersonBeingSilent(Human human) {
        this.malysh = human;
    }

    @Override
    public void run() {
        malysh.beSilent();
    }

    @Override
    public String getState() {
        return "Малыш ничего не ответил.";
    }
}
