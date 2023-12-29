package org.example;

import org.example.characters.Human;
import org.example.exceptions.IllegalPersonMovingException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalPersonMovingException {
        Story story = new Story();
        story.prepare();
        story.go();

        Room room = new Room();
        System.out.println(Arrays.toString(Room.class.getDeclaredFields()));
    }
}
