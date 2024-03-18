package org.pawtropolis.game.controller;
import org.pawtropolis.game.command.classcommand.ExitCommand;
import org.pawtropolis.game.entity.Player;

import java.util.Scanner;


public class GameController {

    private static GameController instance = null;

    private GameController(){

    }

    public static GameController getInstance() {
        if( instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    private final MapController mapController = MapController.getInstance();
    private final Player player = new Player();
    public final Scanner scanner = new Scanner(System.in);
    private final ExitCommand exitCommand = new ExitCommand();

    private final CommandController commandController = CommandController.getInstance(mapController, player, exitCommand);

   public void printRoomName(){
       System.out.println("You are here: " + mapController.getCurrentRoom().getName() + "\n");
    }

    public void printQuestionName(){ System.out.println("Who's playing?\n");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName() + "\n");}

    private void printWriteACommand(){
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
        } while (!exitCommand.isExit());
    }


}