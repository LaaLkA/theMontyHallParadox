package ru.laalka;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
public class Main {
    private static final int COUNT_GAMES = 1000;
    private static Random random = new Random();

    private static int winDoor, playerChoice, openedDoor;

    public static void main(String[] args) {

        Map<Integer, Boolean> changeRes = new HashMap<>();//Храним результат если сменил выбор
        Map<Integer, Boolean> notChangeRes = new HashMap<>();//Храним результат если не изменил выбор

        int winsWithChange = 0;
        int winsWithoutChange = 0;


        for (int i = 0; i < COUNT_GAMES; i++) {
            Game game = new Game();
            boolean winChange = game.playGame(true);
            boolean winWithoutChange = game.playGame(false);

            if (winChange)
                winsWithChange++;
            if(winWithoutChange)
                winsWithoutChange++;

            changeRes.put(i,winChange);
            notChangeRes.put(i, winWithoutChange);
        }
        System.out.println("Выиграли после смены выбора двери: " + winsWithChange);
        System.out.println("Выиграли без смены выбора двери: " + winsWithoutChange);
    }

}