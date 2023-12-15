package org.example.characters;

import org.example.enums.*;

public class Opinion {
    private final Human human2;
    private final Confidence confidence;
    private final Rate rate;
    private final EventType eventType;

    public Opinion(Confidence confidence, Rate rate, Human human2, EventType eventType) {
        this.human2 = human2;
        this.confidence = confidence;
        this.rate = rate;
        this.eventType = eventType;
    }

    public static void addOpinion(Human human, Opinion opinion){
        human.opinions.add(opinion);
        System.out.println(human.getName() + " " + opinion.confidence.getTitle() + " " + opinion.human2.getName() + " " +
                opinion.rate.getTitle() + " в: " + opinion.eventType.getTitle() + ".");
    }
}
