package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Item;
import org.pawtropolis.game.entity.Player;
import org.pawtropolis.game.entity.Room;


public class GetCommand implements Command {
    private final MapController mapController;
    private final Bag bag;
    private final String itemName;

    public GetCommand( MapController mapController, Bag bag, String itemName) {
        this.mapController = mapController;
        this.bag = bag;
        this.itemName = itemName;
    }

    private void printNotEnoughSpace(){
        System.out.println("Not enough space\n");
    }

    private void printInvalidCommand(){
        System.out.println("Invalid command\n");
    }

    public void printCurrentSlotsLeft(){
        System.out.printf("Slots left: %s%n%n", bag.getSlotsCapacity());
    }


    private void getItem(String name){
        Room currentRoom = mapController.getCurrentRoom();
        Item item = currentRoom.getItemFromRoom(name);

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
    public void execute() {
        getItem(itemName);
    }
}
