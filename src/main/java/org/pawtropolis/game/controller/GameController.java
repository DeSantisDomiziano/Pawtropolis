package org.pawtropolis.game.controller;

import lombok.Setter;
import org.pawtropolis.game.entity.Player;

import java.util.Scanner;

public class GameController {

    private static GameController instance = null;

    private GameController() {
    }

    private final MapController mapController = MapController.getInstance();
    private final Player player = new Player();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandController commandController = CommandController.getInstance(mapController, player);
    @Setter
    private boolean quitGame = false;


    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public boolean getQuitGame() {
        return quitGame;
    }


    public void printRoomName() {
        System.out.println("You are here: " + mapController.getCurrentRoom().getName() + "\n");
    }

    public void printQuestionName() {
        System.out.println("Who's playing?\n");
    }

    public void printWelcomeName() {
        System.out.println("welcome " + player.getName() + "\n");
    }

    private void printWriteACommand() {
        System.out.print("Write a command:\n> ");
    }


    public void startGame() {
        mapController.createGraph();
        printQuestionName();
        player.setName(scanner.nextLine());
        printWelcomeName();

        do {
            printRoomName();
            mapController.getCurrentRoom().printAdjacentRoom();
            player.printCurrentLifePoints();
            printWriteACommand();
            String command = scanner.nextLine().trim();
            commandController.launchCommand(command);
        } while (!getQuitGame());

        scanner.close();
    }

}