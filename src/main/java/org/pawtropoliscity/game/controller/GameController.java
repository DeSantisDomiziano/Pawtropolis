package org.pawtropoliscity.game.controller;
import org.pawtropoliscity.game.entity.Move;
import org.pawtropoliscity.game.entity.Room;

import java.util.Scanner;
import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.entity.Player.player;

public class GameController {

    private static GameController instance = null;

    private GameController(){}

    public static GameController getInstance() {
        if( instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    private final MapController mapController = MapController.getInstance();
    private final MoveController moveController = MoveController.getInstance();
    private final CommandController commandController = CommandController.getInstance();
    private boolean exit = false;


    public static Scanner scanner = new Scanner(System.in);


    public void printRoomName(){
        System.out.println("You are here: " + roomMap.get(player.getCoordinate()).getName() + "\n");
    }
    public static void printInvalidCommand(){
        System.out.println("Insert a valid command.");
    }
    public void printQuestionName(){ System.out.println("Who's playing?");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName());}

    public void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + player.getLifePoints());
    }
    public void printGameOver(){
        System.out.println(" GAME OVER " );
    }

    private void printCommand(){
        System.out.print("Write a command:\n> ");
    }

    private void printExitMessage(){System.out.println("game closed");}

    public void currentLifePoints() {
        Room room = roomMap.get(player.getCoordinate());
        player.decrementLifePoints(room);
        printCurrentLifeOfPoint();

        if (player.isDead()){
            printGameOver();
            System.exit(0);
        }
    }


    public void startGame(){

        mapController.createRoom();

        printQuestionName();
        player.setName(scanner.nextLine());
        printWelcomeName();
        printRoomName();

        do{
            printCommand();
            String command = scanner.nextLine().trim();

            if (command.startsWith("go")) {
                try {
                    Move move = Move.valueOf(command.substring(3).toUpperCase().trim());
                    moveController.movePlayer(move);
                    currentLifePoints();
                }catch (IllegalArgumentException e) {
                    System.out.println("direction not exists");
                }

            }else if(command.startsWith("get") || command.startsWith("drop")) {
                String[] splitCommand = command.split(" ");
                String nameItem = splitCommand[splitCommand.length -1];
                String actionCommand = splitCommand[0];

                switch (actionCommand) {
                    case "get":
                        commandController.getItem(nameItem);
                        break;
                    case "drop":
                        commandController.dropItem(nameItem);
                        break;
                }

            } else {
                switch (command){
                    case "look":
                        commandController.lookRoom();
                        break;
                    case "bag":
                        commandController.lookBag();
                        break;
                    case "exit":
                        exit = !exit;
                        printExitMessage();
                        break;
                    default:
                        printInvalidCommand();
                        break;
                }
            }
        } while (!exit);
    }
}