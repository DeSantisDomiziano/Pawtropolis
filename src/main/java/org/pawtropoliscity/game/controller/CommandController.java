package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Bag;
import org.pawtropoliscity.game.entity.Player;
import org.pawtropoliscity.game.entity.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.pawtropoliscity.game.controller.MoveController.printCommandNotFound;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class CommandController {

    private static CommandController instance = null;

    private CommandController(){}

    public static CommandController getInstance() {
        if( instance == null) {
            instance = new CommandController();
        }
        return instance;
    }
    private final Bag bag = new Bag(new ArrayList<>(), 20);
    private final Room room = new Room("", new ArrayList<>(), new ArrayList<>());
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
    public void printTurnOff(){
        System.out.println("Turn off\n");
    }
    public void printQuestionName(){ System.out.println("Who's playing?");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName());}

    public static void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + CommandController.player.getLifePoints());
    }
    public static void printLifeOfPointFinish(){
        System.out.println(" GAME OVER " );
    }

    private void printCommand(){
        System.out.println("Write a command:\n");
    }
    public void printExit(){
        System.out.println("You exit\n");
    }

   /* public static void pointOfPlayer(){
        Room room= roomMap.get(userPosition);
        List<Item> itemList = room.getListItem();
        for( Item item: itemList) {
            if(item.getName().equals("poison")) {
                if(room.getListItem().contains(item)) {
                    CommandController.player.setLifePoints((int) (player.getLifePoints() - item.getSlotsRequired()));
                }
            }
        }
        if (player.getLifePoints() == 0){
            printLifeOfPointFinish();
            System.exit(0);
        } else {
            printCurrentLifeOfPoint();
        }
    }*/



    public void startGame() {
        mapController.createMap();
        printQuestionName();

        String name = scanner.nextLine();
        if (name != null) {
            printRoomName();
            player.setName(name);
            printWelcomeName();
            do {
                printCommand();
                try {
                    String command = scanner.nextLine();
                    switch (command) {
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
                            room.printItems();
                            String itemNameToAdd = scanner.nextLine();
                            bag.addItem(itemNameToAdd);
                            room.removeItem(itemNameToAdd);
                            break;
                        case "drop item":
                            bag.printItem();
                            String itemNameToRemove = scanner.nextLine();
                            room.addItem(itemNameToRemove);
                            bag.removeItem(itemNameToRemove);
                            break;
                        case "look room":
                            room.lookRoom();
                            break;
                        case "look bag":
                            bag.lookBag();
                            break;
                        case "exit":
                            printExit();
                            System.exit(0);
                        default:
                            printCommandNotFound();
                            break;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    printInsertValidNumber();
                    scanner.nextLine();
                }
            } while (true);
        }
    }

}