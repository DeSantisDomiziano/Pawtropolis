package org.pawtropoliscity.game.controller;
import java.util.Scanner;
import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.entity.Player.player;

public class GameController {

    private static GameController instance = null;
    protected static boolean exit = false;

    private GameController(){

    }

    public static GameController getInstance() {
        if( instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    private final MapController mapController = MapController.getInstance();
    private final CommandController commandController = CommandController.getInstance();

    public static Scanner scanner = new Scanner(System.in);


    public void printRoomName(){
        System.out.println("You are here: " + roomMap.get(player.getCoordinate()).getName() + "\n");
    }
    public void printQuestionName(){ System.out.println("Who's playing?\n");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName() + "\n");}

    private void printWriteACommand(){
        System.out.print("Write a command:\n> ");
    }


    public void startGame() {
        mapController.createRoom();
        printQuestionName();
        player.setName(scanner.nextLine());
        printWelcomeName();
        printRoomName();

        do {
            printWriteACommand();
            String command = scanner.nextLine().trim();
            commandController.locateCommand(command);
        } while (!exit);
    }


}