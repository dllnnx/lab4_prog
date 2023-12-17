package org.example.characters;

import org.example.enums.EventType;

import java.util.List;

public class Event {
    private Essence essence;
    private final EventType type;

    public Event(Essence human, EventType type) {
        this.essence = human;
        this.type = type;
    }

    public Essence getEssence() {
        return essence;
    }

    public void setEssence(Essence essence) {
        this.essence = essence;
    }

    public EventType getType() {
        return type;
    }

    public static void addEvents(Human human, Event... events1){
        human.events.addAll(List.of(events1));
    }
}
