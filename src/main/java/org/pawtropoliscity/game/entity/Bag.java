package org.pawtropoliscity.game.entity;
import org.pawtropoliscity.game.factory.ItemFactory;

import java.util.ArrayList;
import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class Bag {

    private static List<Item> items = new ArrayList<>();
    private double slotsCapacity;

    public Bag(List<Item> items, double slotsCapacity) {
        Bag.items = items;
        setSlotsCapacity(slotsCapacity);
    }


    public double getSlotsCapacity() {
        return slotsCapacity;
    }

    private void setSlotsCapacity(double slotsCapacity) {
        this.slotsCapacity = slotsCapacity;
    }

    public double getTotalWeightItem(){
        return items.stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }

    public boolean checkWeight(Item item){
        if (getSlotsCapacity() >= getTotalWeightItem() + item.getSlotsRequired()){
            return true;
        }else {
            System.out.println("Not enough space");
            return false;
        }
    }

    public void lookBag(){
        if (items.isEmpty()) {
            System.out.println("There are no items\n");
        } else {
            items.stream()
                    .map(item -> items.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }

    public static Item getItemFromBag(String itemName){
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void addItem(String itemName){
        Item item = roomMap.get(userPosition).getItemFromRoom(itemName);
        if (item != null){
            if (checkWeight(item)){
                items.add(item);
            }else {
                System.out.println("There are no items\n");
            }
        }
    }

    public void removeItem(String itemName){
        Item item = getItemFromBag(itemName);
        if (item != null){
            items.remove(item);
        }else {
            System.out.println("There are no items\n");
        }
    }

    public void printItem(){
        if (!items.isEmpty()){
            items.stream()
                    .map(item -> items.indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
        }
    }
}























     /*


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
                        printCommandNotFound();
                    }
                break;
                case 2:
                break;
                default:
                    printCommandNotFound();
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
                        Item itemToDrop = bag.getItems().get(indexItemToDrop - 1);
                        removeItem(itemToDrop);
                    } else {
                        printCommandNotFound();
                    }
                    break;
                case 2:
                    break;
                default:
                    printCommandNotFound();
                    break;
            }
        }catch (InputMismatchException | NumberFormatException e) {
            printInsertValidNumber();
            scanner.nextLine();
        }

    }
    */

