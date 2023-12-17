package org.example.characters;

import org.example.Room;
import org.example.enums.*;
import org.example.exceptions.IllegalPersonMovingException;
import org.example.interfaces.Singable;

public class FlyingPerson extends Human {
    public FlyingPerson(String name) {
        super(name);
    }

    public void fly(Comparison comparison, Room room){
        System.out.println(this.getName() + " влетел в " + room.getName() + " " + comparison.getTitle() + ".");
        try {
            room.addPerson(this);
        } catch (IllegalPersonMovingException e) {
            System.out.println(e);
        }
    }

    public void flyInCircles(String place, Count count){
        System.out.println(this.getName() + " сделал " + count.getTitle() + " кругов " + place + ".");
    }

    public void slowDown(String reason){
        System.out.println(this.getName() + " сбавил скорость, потому что " + reason + ".");
    }

    public void flyBy(String object){
        System.out.println(this.getName() + " пролетает мимо: " + object + ".");
    }

}