package org.java.game.controller;
import org.java.game.entity.Bag;
import org.java.game.entity.Item;
import java.util.ArrayList;
import java.util.stream.IntStream;
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

    public void printNotEnoughSpace(){
        System.out.println("Not enough space");
    }
    public void printItemsNotFound(){
        System.out.println("Item not found");
    }
    public void printHaveNothing(){
        System.out.println("you don't have anything");
    }
    public double getTotalWeightItem(){
        return bag.getItems().stream()
                .mapToDouble(Item::getSlotsRequired)
                .sum();
    }



    public void addItem(Item item){
        if (bag.getSlotBag() > getTotalWeightItem() + item.getSlotsRequired()){
            bag.getItems().add(item);
            roomMap.get(userPosition).getListItem().remove(item);
        }else {
            printNotEnoughSpace();
        }
    }

    public void removeItem(Item item){
        if (bag.getItems().contains(item)){
            bag.getItems().remove(item);
            roomMap.get(userPosition).getListItem().add(item);
        }else {
            printItemsNotFound();
        }
    }

    public void lookRoom(){
        System.out.println("You are in " + roomMap.get(userPosition).getName()
                            + "\nItems: " + roomMap.get(userPosition).getListItem().toString()
                            + "\nNPC: " + roomMap.get(userPosition).getListAnimal().toString());
    }

    public void lookBag(){
        if (bag.getItems().isEmpty()) {
            printHaveNothing();
        } else {
            IntStream.range(0, bag.getItems().size())
                    .forEach(i -> System.out.print(i + 1 + ")" + bag.getItems().get(i).getName() + " "));
            System.out.println();
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
