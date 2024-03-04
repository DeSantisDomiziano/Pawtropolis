package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.controller.MapController;
import org.pawtropolis.game.entity.Bag;
import org.pawtropolis.game.entity.Item;
import org.pawtropolis.game.entity.Player;

public class DropCommand implements Command {
    private final MapController mapController;
    private final Player player;
    private final Bag bag;
    private final String itemName;


    public DropCommand(MapController mapController, Player player, Bag bag, String itemName) {
        this.mapController = mapController;
        this.player = player;
        this.bag = bag;
        this.itemName = itemName;
    }

    private void printNoItem(){
        System.out.println("Item not found\n");
    }

    public void printCurrentSlotsLeft(){
        System.out.printf("Slots left: %s%n%n", bag.getSlotsCapacity());
    }



    private void dropItem(String name){
        Item item = bag.getItemFromBag(name);

        if (bag.containsItemInBag(item)){
            mapController.getRoom(player.getCoordinate()).addItem(item);
            bag.removeItem(item);
            bag.incrementCurrentSlotsCapacity(item);
            printCurrentSlotsLeft();
        }else {
            printNoItem();
        }
    }

    @Override
    public void execute() {
        dropItem(itemName);
    }
}
