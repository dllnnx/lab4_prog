package org.example.actions;

import org.example.Room;
import org.example.characters.Human;
import org.example.enums.Position;
import org.example.exceptions.IllegalPersonMovingException;

public class PersonComesInTheRoom implements Action{
    private final Human malysh;
    private final Room roomMalysh;
    private final Human karlson;


    public PersonComesInTheRoom(Human malysh, Room roomMalysh, Human karlson){
        this.karlson = karlson;
        this.malysh = malysh;
        this.roomMalysh = roomMalysh;
    }

    @Override
    public void run() {
        malysh.setPosition(Position.UP);
        malysh.printState();
        try {
            roomMalysh.addPerson(karlson);
        } catch (IllegalPersonMovingException e){
            System.out.println(e);
        }
        malysh.setPosition(Position.UP);
    }

    @Override
    public String getState() {
        return "Малыш вскочил на ноги и стоял, не помня себя от восторга: так он был рад, что Карлсон вернулся.";
    }
}
