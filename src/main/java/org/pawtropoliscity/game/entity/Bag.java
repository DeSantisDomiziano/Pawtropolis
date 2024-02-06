package org.pawtropoliscity.game.entity;
import java.util.ArrayList;
import java.util.List;

import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class Bag {

    private List<Item> items = new ArrayList<>();
    private double slotsCapacity;

    public Bag(List<Item> items, double slotsCapacity) {
        this.items = items;
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

    public void addItem(Item item){
        if (getSlotsCapacity() >= getTotalWeightItem() + item.getSlotsRequired()) items.add(item);

    }


    public void removeItem(Item item){
        if (getItems().contains(item)){
            getItems().remove(item);
            roomMap.get(userPosition).getListItem().add(item);
            printItemRemovedFromBag(item);
        }else {
            printItemsNotFound();
        }
    }


    public void lookBag(){
        if (getItems().isEmpty()) {
            printHaveNothing();
        } else {
            bag.getItems().stream()
                    .map(item -> getItems().indexOf(item) + 1 + ") " + item.getName())
                    .forEach(System.out::println);
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
}
