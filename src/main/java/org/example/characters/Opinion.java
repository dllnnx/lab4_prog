package org.example.characters;

import org.example.enums.*;

public class Opinion {

    public static class OpinionAboutPerson {
        private final Confidence confidence;
        private final Human human2;
        private final Rate rate;
        private final EventType eventType;

        public OpinionAboutPerson(Confidence confidence, Rate rate, Human human2, EventType eventType) {
            this.confidence = confidence;
            this.human2 = human2;
            this.rate = rate;
            this.eventType = eventType;
        }

        public static void addOpinion(Human human, OpinionAboutPerson opinion){
            human.opinionsAboutPeople.add(opinion);
            System.out.println(human.getName() + " " + opinion.confidence.getTitle() + " " + opinion.human2.getName() + " " +
                    opinion.rate.getTitle() + " в: " + opinion.eventType.getTitle() + ".");
        }


    }

    public static class OpinionAboutEvent {
        private final Event event;
        private final Characterization characterization;

        public OpinionAboutEvent(Event event, Characterization characterization) {
            this.event = event;
            this.characterization = characterization;
        }

        public static void addOpinion(Human human, OpinionAboutEvent opinionAboutEvent){
            human.opinionAboutEvents.add(opinionAboutEvent);
            System.out.println(human.getName() + " считает, что это " + opinionAboutEvent.characterization.getTitle() +
                    ", что " + opinionAboutEvent.event.getEssence().getName() + " " + opinionAboutEvent.event.getType().getTitle() + ".");
        }
    }


}
