package ru.laalka;

import lombok.Data;

import java.util.Random;

@Data
public class Game {
    private static final Random random = new Random();

    public boolean playGame(boolean changeChoice) {
        int winDoor = random.nextInt(3);
        int playerChoice = random.nextInt(3);
        int openedDoor;

        do {
            openedDoor = random.nextInt(3);
        } while (openedDoor == winDoor || openedDoor == playerChoice);

        if (changeChoice) {
            playerChoice = 3 - playerChoice - openedDoor;
        }

        return playerChoice == winDoor;
    }
}
