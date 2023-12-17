package org.example.characters;

import org.example.*;
import org.example.enums.*;
import org.example.exceptions.*;
import org.example.interfaces.*;
import java.util.*;


public class Human extends Essence{
    protected Position position = Position.STAND;
    protected Emotion emotion = Emotion.CALM;
    protected Room location;
    protected List<Event> events = new LinkedList<>();
    protected List<Opinion.OpinionAboutPerson> opinionsAboutPeople = new LinkedList<>();
    protected List<Opinion.OpinionAboutEvent> opinionAboutEvents = new LinkedList<>();
    protected List<String> description = new LinkedList<>();
    protected List<Wish> wishes = new LinkedList<>();

    public Human(String name) {
        super(name);
    }

    public Human(String name, Position position) {
        super(name);
        this.position = position;
    }

    public Human(String name, Position position, Room location) {
        super(name);
        this.position = position;
        try {
            location.addPerson(this);
        } catch (IllegalPersonMovingException e) {
            System.out.println(e);
        }
    }

    public Human(String name, Room location) {
        super(name);
        try {
            location.addPerson(this);
        } catch (IllegalPersonMovingException e){
            System.out.println(e);
        }
    }

    public Human(){};


    // getters & setters

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
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Opinion.OpinionAboutPerson> getOpinionsAboutPeople() {
        return opinionsAboutPeople;
    }

    public Room getLocation() {
        return location;
    }
    public void setLocation(Room location) {
        this.location = location;
    }

    public List<Wish> getWishes() {

        return wishes;
    }
    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

    // methods

    public void printState(){
        // локальный класс State
        class State{
            public void print(){
                if (getLocation() != null){
                    System.out.println(getName() + " " + getPosition().getTitle() + " в " + getLocation().getName() + ".");
                } else {
                    System.out.println(getName() + " " + getPosition().getTitle() + ".");
                }
            }
        }

        State state = new State();
        state.print();
    }

    public void brag(String s, Human human) {
        System.out.println(this.getName() + " хвастается " + s + ".");
        human.setEmotion(Emotion.JEALOUS);
        System.out.println(human.getName() + " " + human.getEmotion().getTitle() + ".");
    }

    public void beSilent(){
        System.out.println(this.getName() + " молчит.");
    }

    public void addDescription(String... descr){
        this.description.addAll(List.of(descr));
    }

    public void hear(String sound){
        System.out.println(this.getName() + " услышал " + sound + ".");
    }

    public void printDescription(){
        System.out.print(this.getName() + " ");
        for (int i = 0; i < description.toArray().length; i++){
            if (i != description.toArray().length - 1){
                System.out.print(description.toArray()[i] + ", ");
            } else {
                System.out.print(description.toArray()[i] + ".");
            }
        }
        System.out.println();
    }

    public void moveHead(HeadMovement movement){
        System.out.println(this.getName() + " " + movement.getTitle() + ".");
    }

    public void squint(){
        System.out.println(this.getName() + " прищуривается.");
    }

    public void interrupt(Human human){
        System.out.println(this.getName() + " прервал размышления " + human.getName() + "а.");
    }

    public void doWithCondition(String condition, String action){
        System.out.println("Если " + condition + ", то " + this.getName() + " " + action + ".");
    }


    // вложенный класс HumanMind, отвечающий за мысли/реакции/эмоции человека
    public class HumanMind implements Reaction {
        public void miss(Human human){
            setEmotion(Emotion.MISS);
            System.out.println(getName() + " скучает по " + human.getName() + "у.");
        }

        public void think(String phrase){
            if (phrase.isEmpty()){
                throw new IllegalPhraseException();
            }
            System.out.println(getName() + " думает: \"" + phrase + "\".");
        }

        @Override
        public void react(Emotion emotion, Human human) {
            setEmotion(emotion);
            System.out.println(getName() + " " + getEmotion().getTitle() + " " + human.getName() + "у.");
        }

        public void remember(Event... events){
            System.out.print(getName() + " вспоминает, ");
            for(int i = 0; i < events.length; i++){
                if (i != events.length - 1){
                    System.out.print("как " + events[i].getEssence().getName() + " " + events[i].getType().getTitle() + ", ");
                } else {
                    System.out.print("как " + events[i].getEssence().getName() + " " + events[i].getType().getTitle() + ".");
                }
            }
            System.out.println();
        }

        public void rememberAboutObject(String object){
            System.out.println(getName() + " вспоминает о " + object + ".");
        }
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
        int result = this.getName().hashCode();
        result += position.hashCode() + emotion.hashCode() + events.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
