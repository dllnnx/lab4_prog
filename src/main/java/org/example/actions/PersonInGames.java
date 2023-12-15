package org.example.actions;

import org.example.characters.*;
import org.example.enums.*;

public class PersonInGames implements Action{
    private final Human malysh;
    private final Human karlson;

    public PersonInGames(Human malysh, Human karlson) {
        this.malysh = malysh;
        this.karlson = karlson;
    }

    @Override
    public void run(){
        Opinion.addOpinion(malysh, new Opinion(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY));
    }

    @Override
    public String getState() {
        return "И уж наверняка он самый лучший в мире товарищ по играм.";
    }
}
