package org.pawtropolis.game.command.classcommand;

import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.entity.Bag;

public class BagCommand implements Command {
    private final Bag bag;

    public BagCommand(Bag bag) {
        this.bag = bag;
    }

    private void lookBag(){
        bag.printItems();
    }


    @Override
    public void execute() {
        lookBag();
    }
}
