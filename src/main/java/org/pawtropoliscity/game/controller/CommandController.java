package org.pawtropoliscity.game.controller;
import org.pawtropoliscity.game.entity.Bag;
import org.pawtropoliscity.game.entity.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.pawtropoliscity.game.controller.GameController.printInsertValidNumber;
import static org.pawtropoliscity.game.controller.GameController.scanner;
import static org.pawtropoliscity.game.controller.MapController.roomMap;
import static org.pawtropoliscity.game.controller.MoveController.printCommandNotFound;
import static org.pawtropoliscity.game.controller.MoveController.userPosition;

public class CommandController {
    Bag bag = new Bag(new ArrayList<>(), 20.0);

    private static CommandController instance = null;

    private CommandController(){

    }

    public static CommandController getInstance() {
        if( instance == null) {
            instance = new CommandController();
        }
        return instance;
    }

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


}