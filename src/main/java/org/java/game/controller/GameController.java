package org.java.game.controller;

import org.java.game.entity.Item;
import org.java.game.entity.Player;
import org.java.game.entity.Room;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.java.game.controller.MapController.roomMap;
import static org.java.game.controller.MoveController.userPosition;

public class GameController {

    private static GameController instance = null;
    public static GameController getInstance() {
        if( instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    ActionController actionController = ActionController.getInstance();
    MapController mapController = MapController.getInstance();
    MoveController moveController = MoveController.getInstance();
    public static Player player = new Player("", 100);

    public static Scanner scanner = new Scanner(System.in);


    public void printRoomName(){
        System.out.println("You are here: " + MapController.roomMap.get(userPosition).getName() + "\n");
    }
    public static void printInsertValidNumber(){
        System.out.println("Insert a valid number.");
    }
    public void printInputCommand(){
        System.out.println("Type the number to give the command:" +
                "\n1) - go to" +
                "\n2) - get items" +
                "\n3) - drop" +
                "\n4) - look" +
                "\n5) - bag" +
                "\n6) - exit" +
                "\n");
    }
    public void printMoveCommand(){
        System.out.println("Choose direction: go to" +
                "\n1) - north" +
                "\n2) - south" +
                "\n3) - west" +
                "\n4) - east" +
                "\n5) - exit" +

                "\n");
    }
    public void printTurnOff(){
        System.out.println("Turn off\n");
    }
    public void printQuestionName(){ System.out.println("Who's playing?");}
    public void printWelcomeName(){ System.out.println("welcome " + player.getName());}

    public static void printCurrentLifeOfPoint(){
        System.out.println("your current life of point are : " + GameController.player.getLifePoints());
    }

    public static void pointOfPlayer(){
        Room room= roomMap.get(userPosition);
        List<Item> itemList = room.getListItem();
        for( Item item: itemList) {
            if(item.getName().equals("poison")) {
                if(room.getListItem().contains(item)) {
                    GameController.player.setLifePoints((int) (GameController.player.getLifePoints() - item.getSlotsRequired()));
                }
            }
        }
        printCurrentLifeOfPoint();
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
                            actionController.addItemsToBag();
                            break;
                        case 3:
                            actionController.removeItemsFromBag();
                            break;
                        case 4:
                            actionController.lookRoom();
                            break;
                        case 5:
                            actionController.lookBag();
                            break;
                        case 6:
                            printTurnOff();
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            moveController.printCommandNotFound();
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    printInsertValidNumber();
                    scanner.nextLine();
                }
            } while (true);
        }
    }

}
