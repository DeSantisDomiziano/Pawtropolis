package org.pawtropolis.game.command.classcommand;

import lombok.AllArgsConstructor;
import org.pawtropolis.game.command.iface.CommandParameterized;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Item;
import org.pawtropolis.game.entity.Room;

@AllArgsConstructor
public class GetCommand implements CommandParameterized {
    private final MapController mapController;
    private final Bag bag;

    private void printNotEnoughSpace(){
        System.out.println("Not enough space\n");
    }

    private void printInvalidCommand(){
        System.out.println("Invalid command\n");
    }

    public void printCurrentSlotsLeft(){
        System.out.printf("Slots left: %s%n%n", bag.getSlotsCapacity());
    }


    private void getItem(String itemName){
        Room currentRoom = mapController.getCurrentRoom();
        Item item = currentRoom.getItemFromRoom(itemName);

        if (currentRoom.containsItemInRoom(item)){
            if (bag.canFitInBag(item)){
                bag.addItem(item);
                currentRoom.removeItem(item);
                bag.decrementCurrentSlotsCapacity(item);
                printCurrentSlotsLeft();
            }else {
                printNotEnoughSpace();
            }
        }else {
            printInvalidCommand();
        }
    }

    @Override
    public void execute(String itemName) {
        getItem(itemName);
    }

    @Override
    public void execute() {

    }
}
