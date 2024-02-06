package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Item;
import org.pawtropoliscity.game.entity.Player;
import org.pawtropoliscity.game.entity.Room;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.printCommandNotFound;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class GameController {

    private static GameController instance = null;

    private GameController(){}

    public static GameController getInstance() {
        if( instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    private final CommandController commandController = CommandController.getInstance();
    private final MapController mapController = MapController.getInstance();
    private final MoveController moveController = MoveController.getInstance();
    public static Player player = new Player("", 100);

    public static Scanner scanner = new Scanner(System.in);


    public void printRoomName(){
        System.out.println("You are here: " + MapController.roomMap.get(userPosition).getName() + "\n");
    }
    public static void printInsertValidNumber(){
        System.out.println("Insert a valid number.");
    }
    public void printInputCommand(){
        System.out.println("""
                Type the number to give the command:
                1) - go to
                2) - get items
                3) - drop
                4) - look
                5) - bag
                6) - exit
                """);

        System.out.println();
    }
    public void printMoveCommand(){
        System.out.println("""
                Choose direction: go to
                1) - north
                2) - south
                3) - west
                4) - east
                5) - exit
                """);

        System.out.println();
    }
    public void printTurnOff(){
        System.out.println("Turn off\n");
    }
    public void printQuestionName(){ System.out.println("Who's playing?");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName());}

    public static void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + GameController.player.getLifePoints());
    }
    public static void printLifeOfPointFinish(){
        System.out.println(" GAME OVER " );
    }

    public static void pointOfPlayer(){
        Room room= roomMap.get(userPosition);
        List<Item> itemList = room.getListItem();
        for( Item item: itemList) {
            if(item.getName().equals("poison")) {
                if(room.getListItem().contains(item)) {
                    GameController.player.setLifePoints((int) (player.getLifePoints() - item.getSlotsRequired()));
                }
            }
        }
        if (player.getLifePoints() == 0){
            printLifeOfPointFinish();
            System.exit(0);
        } else {
            printCurrentLifeOfPoint();
        }
    }



    public void startGame() {
        mapController.createMap();
        printQuestionName();

        String name = scanner.nextLine();
        if (name != null) {
            printRoomName();
            player.setName(name);
            printWelcomeName();
            do {
                printInputCommand();
                try {
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    switch (input) {
                        case 1:
                            printMoveCommand();
                            int command = scanner.nextInt();
                            scanner.nextLine();
                            moveController.changeRoom(command);
                            break;
                        case 2:
                            commandController.addItemsToBag();
                            break;
                        case 3:
                            commandController.removeItemsFromBag();
                            break;
                        case 4:
                            commandController.lookRoom();
                            break;
                        case 5:
                            commandController.lookBag();
                            break;
                        case 6:
                            printTurnOff();
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            printCommandNotFound();
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    printInsertValidNumber();
                    scanner.nextLine();
                }
            } while (true);
        }
    }

}