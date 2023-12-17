package org.example.characters;

import org.example.enums.Measure;

import java.util.List;

public class Wish {
    private String name;
    private Human human;
    private Measure measure;

    public Wish(String name, Human human, Measure measure) {
        this.name = name;
        this.human = human;
        this.measure = measure;
    }

    public static void addWishes(Wish... wishes){
        for (Wish wish: wishes){
            wish.getHuman().wishes.add(wish);
            System.out.println(wish.getHuman().getName() + " " + wish.getMeasure().getTitle() + " хочет " +
                    wish.getName() + ".");
        }
    }

    public String getName() {
        return name;
    }

    public Human getHuman() {
        return human;
    }

    public Measure getMeasure() {
        return measure;
    }
}
