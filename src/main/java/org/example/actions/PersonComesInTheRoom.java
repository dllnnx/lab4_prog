package org.example.actions;

import org.example.Room;
import org.example.characters.Human;
import org.example.enums.Position;
import org.example.exceptions.IllegalPersonMovingException;
import org.example.interfaces.Action;

public class PersonComesInTheRoom implements Action {
    private final Human malysh;


    public PersonComesInTheRoom(Human malysh){
        this.malysh = malysh;
    }

    @Override
    public void run() {
        malysh.setPosition(Position.UP);
        malysh.printState();
        malysh.setPosition(Position.UP);
    }

    @Override
    public String getState() {
        return "Малыш вскочил на ноги и стоял, не помня себя от восторга: так он был рад, что Карлсон вернулся.";
    }
}
