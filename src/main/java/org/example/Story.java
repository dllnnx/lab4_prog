package org.example;

import org.example.actions.*;
import org.example.characters.*;
import org.example.enums.*;
import org.example.exceptions.*;
import org.example.interfaces.Action;
import org.example.interfaces.Singable;

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
//        LinkedList<Action> actions = new LinkedList<>();
//        actions.addAll(List.of(
//                new PersonBeingSad(malysh, karlson, mom),
//                new PersonThinksAboutTheDay(malysh, day),
//                new PersonMissesSomeone(malysh, karlson),
//                new PersonLiesInTheRoom(malysh, (FlyingPerson) karlson, roomMalysh),
//                new PersonFliesInsideTheRoom((FlyingPerson) karlson),
//                new PersonComesInTheRoom(malysh),
//                new PersonThinksAboutFriends(malysh, krister, gunilla, karlson),
//                new PersonThinksAboutEffa(malysh),
//                new PersonWantsADog(malysh, karlson),
//                new PersonWantsToShowSomeone(malysh)
//        ));

//        actions.forEach((action -> {
//            action.run();
//            System.out.println(action.getState() + "\n");
//        }));

//        for (int i = 0; i < 3; i++){
//            actions.get(i).run();
//        }

//        actions.forEach(Action::run);

        Action personBeingSad = new Action() {
            @Override
            public void run() {
                malysh.beSilent();
                Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.STEAMENGINE));
                Opinion.OpinionAboutEvent.addOpinion(malysh, new Opinion.OpinionAboutEvent(new Event(mom, EventType.SPANK),
                        Characterization.BAD));
            }

            @Override
            public String getState() {
                return "Малыш ничего не ответил." +
                        "Ему показалось ужасным, что мама собирается отшлепать лучшего в мире специалиста по паровым машинам.";
            }
        };

        Action personThinksAboutTheDay = new Action() {
            @Override
            public void run() {
                Opinion.OpinionAboutEvent.addOpinion(malysh,
                        new Opinion.OpinionAboutEvent(new Event(day, EventType.TOPSYTORVY), Characterization.BAD));
            }

            @Override
            public String getState() {
                return "Да, ничего хорошего нельзя было ожидать в такой неудачный день, когда буквально все шло шиворот-навыворот.";
            }
        };

        Action personMissesSomeone = new Action() {
            @Override
            public void run() {
                Human.HumanMind malyshMind = malysh.new HumanMind();
                malyshMind.miss(karlson);
                karlson.addDescription("бодрый", "веселый");
                karlson.printDescription();
                malyshMind.remember(new Event(karlson, EventType.WAVE), new Event(karlson, EventType.TALKGOOD));

                malyshMind.think("Неужели Карлсон больше никогда не прилетит?");
                malysh.setEmotion(Emotion.ANXIETY);
                System.out.println(malysh.getName() + " " + malysh.getEmotion().getTitle() + ".");
            }

            @Override
            public String getState() {
                return "И вдруг Малыш почувствовал, что он очень соскучился по Карлсону -- бодрому, веселому человечку, " +
                        "который так потешно махал своей маленькой рукой, приговаривая: " +
                        "\"Неприятности -- это пустяки, дело житейское, и расстраиваться тут нечего\". " +
                        "\"Неужели Карлсон больше никогда не прилетит?\" -- с тревогой подумал Малыш.";
            }
        };

        Action personLiesInTheRoom = new Action() {
            @Override
            public void run() {
                malysh.setPosition(Position.LIE);
                malysh.printState();
                malysh.setPosition(Position.READ);
                malysh.printState();
                malysh.hear("какое-то жужжание");
                ((FlyingPerson) karlson).fly(Comparison.LIKEABEE, roomMalysh);
            }

            @Override
            public String getState() {
                return "Малыш лежал на полу в своей комнате и читал книгу, когда снова услышал за окном какое-то жужжание, " +
                        "и, словно гигантский шмель, в комнату влетел Карлсон. ";
            }
        };

        Action personFliesInsideTheRoom = new Action() {
            @Override
            public void run() {
                ((FlyingPerson) karlson).flyBy("картины");
                ((FlyingPerson) karlson).slowDown("рассматривает картины");
                karlson.moveHead(HeadMovement.BOW);
                karlson.squint();
                ((FlyingPerson) karlson).flyInCircles("под потолком", Count.FEW);
                // анонимный класс
                Singable singable = new Singable() {
                    @Override
                    public void sing(Human human, String song) {
                        System.out.println(human.getName() + " напевает " + song + ".");
                    }
                };
                singable.sing(karlson, "какую-то веселую песенку");
            }

            @Override
            public String getState() {
                return "Пролетая мимо висящих на стенах картин, он всякий раз сбавлял скорость, чтобы лучше их рассмотреть. " +
                        "При этом он склонял набок голову и прищуривал глазки. " +
                        "Он сделал несколько кругов под потолком, напевая вполголоса какую-то веселую песенку.";
            }
        };

        Action personComesInTheRoom = new Action() {
            @Override
            public void run() {
                malysh.setPosition(Position.UP);
                malysh.printState();
                malysh.setPosition(Position.UP);
            }

            @Override
            public String getState() {
                return "Малыш вскочил на ноги и стоял, не помня себя от восторга: так он был рад, что Карлсон вернулся.";
            }
        };

        Action personThinksAboutFriends = new Action() {
            @Override
            public void run() {
                Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.BEST, karlson, EventType.EVERYTHING));
                Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.PROBABLY, Rate.BEST, karlson, EventType.PLAY));
                Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.GOOD, krister, EventType.BEFRIEND));
                Opinion.OpinionAboutPerson.addOpinion(malysh, new Opinion.OpinionAboutPerson(Confidence.DEFINITELY, Rate.GOOD, gunilla, EventType.BEFRIEND));
                krister.brag("собакой Еффой", malysh);
            }

            @Override
            public String getState() {
                return "Малыш не сомневался, что Карлсон во всем \"лучший в мире\". " +
                        "И уж наверняка он самый лучший в мире товарищ по играм. В этом Малыш убедился на собственном опыте... " +
                        "Правда, Кристер, и Гунилла тоже хорошие товарищи, но им далеко до Карлсона, который живет на крыше! " +
                        "Кристер только и делает, что хвалится своей собакой Еффой, и Малыш ему давнозавидует.";
            }
        };

        Action personThinksAboutEffa = new Action() {
            @Override
            public void run() {
                Human.HumanMind malyshMind = malysh.new HumanMind();
                malyshMind.think("Если он завтра опять будет хвастаться Еффой, я ему расскажу про Карлсона. " +
                        "Что стоит его Еффа по сравнению с Карлсоном, который живет на крыше! Так я ему и скажу");
            }

            @Override
            public String getState() {
                return "Если он завтра опять будет хвастаться Еффой, я ему расскажу про Карлсона. " +
                        "Что стоит его Еффа по сравнению с Карлсоном, который живет на крыше! Так я ему и скажу.";
            }
        };

        Action personWantsADog = new Action() {
            @Override
            public void run() {
                Wish.addWishes(new Wish("собаку", malysh, Measure.PASSIONATELY));
                karlson.interrupt(malysh);
            }

            @Override
            public String getState() {
                return "Малыш так страстно не желал иметь, как собаку... Карлсон прервал размышления Малыша.";
            }
        };

        Action personWantsToShowSomeone = new Action() {
            @Override
            public void run() {
                Human.HumanMind thinkingPersonMind = karlson.new HumanMind();
                karlson.moveHead(HeadMovement.SHAKE);
                thinkingPersonMind.rememberAboutObject("паровая машина");
                thinkingPersonMind.think("Вот сейчас, когда Карлсон здесь, мама и папа смогут убедиться, что он в самом деле существует");
                karlson.doWithCondition("Боссе и Бетан дома", "покажет Карлсона");
            }

            @Override
            public String getState() {
                return "Малыш покачал головой. Он вспомнил о своей паровой машине и подумал:" +
                        " \"Вот сейчас, когда Карлсон здесь, мама и папа смогут убедиться, что он в самом деле существует\"." +
                        " А если Боссе и Бетан дома, то им он тоже покажет Карлсона.";
            }
        };


        LinkedList<Action> actions = new LinkedList<>();
        actions.addAll(List.of(
                personBeingSad,
                personThinksAboutTheDay,
                personMissesSomeone,
                personLiesInTheRoom,
                personFliesInsideTheRoom,
                personComesInTheRoom,
                personThinksAboutFriends,
                personThinksAboutEffa,
                personWantsADog,
                personWantsToShowSomeone
        ));

        actions.forEach(Action::run);
    }

}
