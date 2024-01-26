package org.java.game.controller;
import org.java.game.entity.Bag;
import org.java.game.entity.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.java.game.controller.GameController.printInsertValidNumber;
import static org.java.game.controller.GameController.scanner;
import static org.java.game.controller.MapController.roomMap;
import static org.java.game.controller.MoveController.userPosition;

public class ActionController {
    Bag bag = new Bag(new ArrayList<>(), 20.0);

    private static ActionController instance = null;
    public static ActionController getInstance() {
        if( instance == null) {
            instance = new ActionController();
        }
        return instance;
    }
    MoveController moveController = MoveController.getInstance();

    public void printNotEnoughSpace(){
        System.out.println("Not enough space\n");
    }
    public void printItemsNotFound(){
        System.out.println("Item not found\n");
    }
    public void printHaveNothing(){
        System.out.println("You don't have anything\n");
    }

    public void printItemAddedToBag(Item item){
        System.out.printf("%s item added to bag and removed from room%n%n", item.getName());
    }

    public void printItemRemovedFromBag(Item item){
        System.out.printf("%s item removed from bag and added to %s%n%n", item.getName(), roomMap.get(userPosition).getName());
    }
    public void printObjectsPresent(){
        System.out.println("these are the objects present, if you want to remove them type 1, if you want to exit type 2");
    }

    public double getTotalWeightItem(){
        return bag.getItems().stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }

    public void addItem(Item item){
                if (bag.getSlotBag() > getTotalWeightItem() + item.getSlotsRequired()) {
                    bag.getItems().add(item);
                    roomMap.get(userPosition).getListItem().remove(item);
                    printItemAddedToBag(item);
                } else {
                    printNotEnoughSpace();
                }
    }

    public void addItemsToBag(){
        if (isItems()) {
            printItems();
        }
        printObjectsPresent();
        try{
            int inputChoose= Integer.parseInt(scanner.nextLine());
            switch (inputChoose) {
                case 1:
                    if (isItems()) {
                        printItems();
                     }
                    int indexItemToGet = Integer.parseInt(scanner.nextLine());
                    if (indexItemToGet <= roomMap.get(userPosition).getListItem().size()) {
                    addItem(roomMap.get(userPosition).getListItem().get(indexItemToGet - 1));
                    } else {
                        moveController.printCommandNotFound();
                    }
                break;
                case 2:
                break;
                default:
                    moveController.printCommandNotFound();
                break;
            }
        }catch (InputMismatchException | NumberFormatException e) {
            printInsertValidNumber();
            scanner.nextLine();
        }
    }



    public void removeItemsFromBag(){
        lookBag();
        printObjectsPresent();
        try{
            int inputChoose= Integer.parseInt(scanner.nextLine());
            switch(inputChoose) {
                case 1:
                    lookBag();
                    int indexItemToDrop = Integer.parseInt(scanner.nextLine());
                    if (indexItemToDrop <= bag.getItems().size()) {
                        Item itemToDrop = bag.getItems().get(indexItemToDrop);
                        removeItem(itemToDrop);
                    } else {
                        moveController.printCommandNotFound();
                    }
                    break;
                case 2:
                    break;
                default:
                    moveController.printCommandNotFound();
                    break;
            }
        }catch (InputMismatchException | NumberFormatException e) {
            printInsertValidNumber();
            scanner.nextLine();
        }

    }

    public void removeItem(Item item){
        if (bag.getItems().contains(item)){
            bag.getItems().remove(item);
            roomMap.get(userPosition).getListItem().add(item);
            printItemRemovedFromBag(item);
        }else {
            printItemsNotFound();
        }
    }

    public void lookRoom(){
        System.out.println("You are here: " + roomMap.get(userPosition).getName() + "\n"
                + "\nItems: " + roomMap.get(userPosition).getListItem().toString()
                + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString() + "\n");
    }

    public void lookBag(){
        if (bag.getItems().isEmpty()) {
            printHaveNothing();
        } else {
            bag.getItems().stream()
                    .map(item -> bag.getItems().indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public void printItems(){
        if (!roomMap.get(userPosition).getListItem().isEmpty()){
            roomMap.get(userPosition).getListItem().stream()
                    .map(item -> roomMap.get(userPosition).getListItem().indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public boolean isItems(){
        if (!roomMap.get(userPosition).getListItem().isEmpty()){
            return true;
        }else {
            System.out.println("Items not found\n");
            return false;
        }
    }


}