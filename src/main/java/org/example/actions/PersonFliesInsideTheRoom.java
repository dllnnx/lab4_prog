package org.example.actions;

import org.example.characters.FlyingPerson;
import org.example.characters.Human;
import org.example.enums.Count;
import org.example.enums.HeadMovement;
import org.example.interfaces.Action;
import org.example.interfaces.Singable;

public class PersonFliesInsideTheRoom implements Action {

    private final FlyingPerson flyingPerson;

    public PersonFliesInsideTheRoom(FlyingPerson flyingPerson) {
        this.flyingPerson = flyingPerson;
    }

    @Override
    public void run() {
        flyingPerson.flyBy("картины");
        flyingPerson.slowDown("рассматривает картины");
        flyingPerson.moveHead(HeadMovement.BOW);
        flyingPerson.squint();
        flyingPerson.flyInCircles("под потолком", Count.FEW);
        // анонимный класс
        Singable singable = new Singable() {
            @Override
            public void sing(Human human, String song) {
                System.out.println(human.getName() + " напевает " + song + ".");
            }
        };
        singable.sing(flyingPerson, "какую-то веселую песенку");
    }

    @Override
    public String getState() {
        return "Пролетая мимо висящих на стенах картин, он всякий раз сбавлял скорость, чтобы лучше их рассмотреть. " +
                "При этом он склонял набок голову и прищуривал глазки. " +
                "Он сделал несколько кругов под потолком, напевая вполголоса какую-то веселую песенку.";
    }
}
