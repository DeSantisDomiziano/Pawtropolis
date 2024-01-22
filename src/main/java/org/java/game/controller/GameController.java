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
        System.out.println("You are here: " + MapController.roomMap.get(MoveController.userPosition).getName() + "\n");
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
                "\n");
    }
    public void printTurnOff(){
        System.out.println("Turn off\n");
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
                    if (indexItemToGet <= roomMap.get(userPosition).getListItem().size() -1){
                        actionController.addItem(roomMap.get(userPosition).getListItem().get(indexItemToGet - 1));
                    }else {
                        moveController.printCommandNotFound();
                    }
                    break;
                case 3:
                    actionController.lookBag();
                    int indexItemToDrop = scanner.nextInt();
                    scanner.nextLine();
                    if (indexItemToDrop <= actionController.getTotalWeightItem()){
                        Item itemToDrop = actionController.getItemFromBag(indexItemToDrop - 1);
                        actionController.removeItem(itemToDrop);
                    }else {
                        moveController.printCommandNotFound();
                    }

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
