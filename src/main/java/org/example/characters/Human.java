package org.example.characters;

import org.example.*;
import org.example.enums.*;
import org.example.exceptions.IllegalPersonMovingException;
import org.example.exceptions.IllegalPhraseException;

import java.util.*;


public class Human implements Reaction {
    protected String name;
    protected Position position = Position.STAND;
    protected Emotion emotion = Emotion.CALM;
    protected List<Event> events = new LinkedList<>();
    protected List<Opinion> opinions = new LinkedList<>();


    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Human(String name, Position position, Room location) {
        this.name = name;
        this.position = position;
        try {
            location.addPerson(this);
        } catch (IllegalPersonMovingException e) {
            System.out.println(e);
        }
    }

    public Human(String name, Room location) {
        this.name = name;
        try {
            location.addPerson(this);
        } catch (IllegalPersonMovingException e){
            System.out.println(e);
        }
    }


    // getters & setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }

    public Emotion getEmotion() {
        return emotion;
    }
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
        System.out.println(this.getName() + " " + emotion.getEmotion() + ".");
    }

    public List<Event> getEvents() {
        return events;
    }


    public List<Opinion> getOpinions() {
        return opinions;
    }


    // methods
    @Override
    public void react(Emotion emotion, Human human) {
        this.emotion = emotion;
        System.out.println(this.getName() + " " + this.getEmotion().getEmotion() + " " + human.getName() + "у.");
    }


    public void printState(){
        System.out.println(this.getName() + " " + this.getPosition().getTitle() + ".");
    }

    public void brag(String s, Human human) {
        System.out.println(this.getName() + " хвастается " + s + ".");
        human.setEmotion(Emotion.JEALOUS);
    }

    public void think(String phrase){
        if (phrase.isEmpty()){
            throw new IllegalPhraseException();
        }
        System.out.println(this.getName() + "думает: \"" + phrase + "\".");
    }

    public void beSilent(){
        System.out.println(this.getName() + " молчит.");
    }


    // Object methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()){ return false; }
        Human human = (Human) obj;
        if (! this.getName().equals((human.getName()))) { return false; }
        if (! this.getPosition().equals(human.getPosition())) { return false; }
        if (! this.getEmotion().equals(human.getEmotion())) { return false; }
        return this.getEvents().equals(human.getEvents());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result += position.hashCode() + emotion.hashCode() + events.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }


}
