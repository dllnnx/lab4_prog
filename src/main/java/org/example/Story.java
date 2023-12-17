package org.example;

import org.example.actions.*;
import org.example.characters.*;
import org.example.enums.*;
import org.example.exceptions.*;
import org.example.interfaces.Action;

import java.util.LinkedList;
import java.util.List;

public class Story {
    private final Human malysh = new Human("Малыш");
    private final Human karlson = new FlyingPerson("Карлсон");
    private final Human krister = new Human("Кристер");
    private final Human gunilla = new Human("Гунилла");
    private final Human mom = new Human("мама");
    private final Room roomMalysh = new Room("комната Малыша");
    private final Day day = new Day("неудачный день");

    public void prepare(){
        try {
            roomMalysh.addPerson(malysh);
        } catch (IllegalPersonMovingException e){
            System.out.println(e);
        }

        Event.addEvents(malysh, new Event(karlson, EventType.PAINT), new Event(karlson, EventType.PLAY),
                new Event(karlson, EventType.CLEANUP));
        Event.addEvents(malysh, new Event(krister, EventType.BRAG));

    }

    public void go(){
        LinkedList<Action> actions = new LinkedList<>();
        actions.addAll(List.of(
                new PersonBeingSad(malysh, karlson, mom),
                new PersonThinksAboutTheDay(malysh, day),
                new PersonMissesSomeone(malysh, karlson),
                new PersonLiesInTheRoom(malysh, (FlyingPerson) karlson, roomMalysh),
                new PersonFliesInsideTheRoom((FlyingPerson) karlson),
                new PersonComesInTheRoom(malysh),
                new PersonThinksAboutFriends(malysh, krister, gunilla, karlson),
                new PersonThinksAboutEffa(malysh),
                new PersonWantsADog(malysh, karlson),
                new PersonWantsToShowSomeone(malysh)
        ));

//        actions.forEach((action -> {
//            action.run();
//            System.out.println(action.getState() + "\n");
//        }));

//        for (int i = 0; i < 3; i++){
//            actions.get(i).run();
//        }

        actions.forEach(Action::run);
    }

}
