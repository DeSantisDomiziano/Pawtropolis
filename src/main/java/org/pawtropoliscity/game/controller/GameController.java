package org.pawtropoliscity.game.controller;
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


    public static Scanner scanner = new Scanner(System.in);


    public void printRoomName(){
        System.out.println("You are here: " + roomMap.get(player.getCoordinate()).getName() + "\n");
    }
    public static void printInvalidCommand(){
        System.out.println("Insert a valid command.");
    }
    public void printQuestionName(){ System.out.println("Who's playing?");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName());}

    public static void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + player.getLifePoints());
    }
    public static void printLifeOfPointFinish(){
        System.out.println(" GAME OVER " );
    }

    private void printCommand(){
        System.out.println("Write a command:\n");
    }

    private void exit(){System.out.println("game closed");}






    public void startGame(){

        mapController.createRoom();

        printQuestionName();
        player.setName(scanner.nextLine());
        printWelcomeName();
        printRoomName();

        do{
            printCommand();
            String command = scanner.nextLine();

            switch (command){
                case "go north":
                    moveController.goToNorth();
                    break;
                case "go south":
                    moveController.goToSouth();
                    break;
                case "go west":
                    moveController.goToWest();
                    break;
                case "go east":
                    moveController.goToEast();
                    break;
                case "get item":
                    MapController.roomMap.get(player.getCoordinate()).printItemList();
                    if (MapController.roomMap.get(player.getCoordinate()).checkEmptyListItem()){
                        String itemNameToAdd = scanner.nextLine().toLowerCase();
                        commandController.getItem(itemNameToAdd);
                    }
                    break;
                case "drop item":
                    commandController.getBag().printItemList();
                    if (commandController.getBag().checkEmptyListItem()){
                        String itemNameToRemove = scanner.nextLine().toLowerCase();
                        commandController.dropItem(itemNameToRemove);
                    }
                    break;
                case "look room":
                    commandController.lookRoom();
                    break;
                case "look bag":
                    commandController.lookBag();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    printInvalidCommand();
                    break;
            }
        }while (true);
    }

}