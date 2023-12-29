package org.example;

import org.example.characters.Human;
import org.example.interfaces.Action;

public class ActionCl implements Action {
    private Human human1, human2, human3, human4;
    private String state;

    public ActionCl(Human human1, Human human2, Human human3, Human human4, String state) {
        this.human1 = human1;
        this.human2 = human2;
        this.human3 = human3;
        this.human4 = human4;
        this.state = state;
    }

    public ActionCl(Human human1, Human human2, Human human3, String state) {
        this.human1 = human1;
        this.human2 = human2;
        this.human3 = human3;
        this.state = state;
    }

    public ActionCl(Human human1, Human human2, String state) {
        this.human1 = human1;
        this.human2 = human2;
        this.state = state;
    }

    public ActionCl(Human human1, String state) {
        this.human1 = human1;
        this.state = state;
    }

    @Override
    public void run() {

    }

    @Override
    public String getState() {
        return state;
    }
}
