package org.pawtropolis.game.command.classcommand;

import lombok.AllArgsConstructor;
import org.pawtropolis.game.command.iface.CommandParameterized;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Item;
import org.pawtropolis.game.entity.Room;

@AllArgsConstructor
public class DropCommand implements CommandParameterized {
    private final MapController mapController;
    private final Bag bag;


    private void printNoItem(){
        System.out.println("Item not found\n");
    }

    public void printCurrentSlotsLeft(){
        System.out.printf("Slots left: %s%n%n", bag.getSlotsCapacity());
    }



    private void dropItem(String itemName){
        Room currentRoom = mapController.getCurrentRoom();
        Item item = bag.getItemFromBag(itemName);

        if (bag.containsItemInBag(item)){
            currentRoom.addItem(item);
            bag.removeItem(item);
            bag.incrementCurrentSlotsCapacity(item);
            printCurrentSlotsLeft();
        }else {
            printNoItem();
        }
    }

    @Override
    public void execute(String itemName) {
        dropItem(itemName);
    }

    @Override
    public void execute() {

    }
}
