package org.pawtropolis.game.command.classcommand;

import lombok.AllArgsConstructor;
import org.pawtropolis.game.command.iface.Command;
import org.pawtropolis.game.entity.Bag;

@AllArgsConstructor
public class BagCommand implements Command {
    private final Bag bag;

    private void lookBag(){
        bag.printItems();
    }


    @Override
    public void execute() {
        lookBag();
    }
}
