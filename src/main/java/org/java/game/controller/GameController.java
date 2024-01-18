package org.java.game.controller;

import org.java.game.entity.Item;

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
    Scanner scanner = new Scanner(System.in);



    public void printRoomName(){
        System.out.println("the room you are in is : " + MapController.roomMap.get(MoveController.userPosition).getName());
    }
    public void printInputCommand(){
        System.out.println("type the number to give the command:\n1)go to\n2)get items\n3)drop\n4)look\n5)bag\n6)exit");
    }
    public void printMoveCommand(){
        System.out.println("choose direction: go to\n1)north\n2)south\n3)west\n4)east");
    }
    public void printTurnOff(){
        System.out.println("Turn off");
    }

    public void startGame() {
        mapController.createMap();
        printRoomName();
        do {
            printInputCommand();
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
                    actionController.lookItems();
                    int indexItemToGet = scanner.nextInt();
                    scanner.nextLine();
                    actionController.addItem(roomMap.get(userPosition).getListItem().get(indexItemToGet - 1));
                    break;
                case 3:
                    actionController.lookBag();
                    int indexItemToDrop = scanner.nextInt();
                    scanner.nextLine();
                    Item itemToDrop = actionController.getItemFromBag(indexItemToDrop - 1);
                    actionController.removeItem(itemToDrop);
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
        } while (true);
    }

}
