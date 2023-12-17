package org.example.characters;

public class Friends {

    public static boolean isFriend(Human human1, Human human2){
        int friendCnt = 0;
        for (Event e: human1.events){
            if (e.getEssence().equals(human2)){
                if (e.getType().getRate().equals("хорошо")) friendCnt++;
                else friendCnt--;
            }
        }
        return (friendCnt >= 0);
    }

}
