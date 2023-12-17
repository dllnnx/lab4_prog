package org.example.actions;

import org.example.Room;
import org.example.characters.FlyingPerson;
import org.example.characters.Human;
import org.example.enums.Comparison;
import org.example.enums.Position;
import org.example.interfaces.Action;

public class PersonLiesInTheRoom implements Action {
    private final Human malysh;
    private final FlyingPerson karlson;
    private final Room malyshRoom;

    public PersonLiesInTheRoom(Human malysh, FlyingPerson karlson, Room malyshRoom) {
        this.malysh = malysh;
        this.karlson = karlson;
        this.malyshRoom = malyshRoom;
    }

    @Override
    public void run() {
        malysh.setPosition(Position.LIE);
        malysh.printState();
        malysh.setPosition(Position.READ);
        malysh.printState();
        malysh.hear("какое-то жужжание");
        karlson.fly(Comparison.LIKEABEE, malyshRoom);
    }

    @Override
    public String getState() {
        return "Малыш лежал на полу в своей комнате и читал книгу, когда снова услышал за окном какое-то жужжание, " +
                "и, словно гигантский шмель, в комнату влетел Карлсон. ";
    }
}
