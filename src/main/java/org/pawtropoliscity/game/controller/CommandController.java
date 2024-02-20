package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Bag;
import org.pawtropoliscity.game.entity.Item;

import java.util.HashMap;
import java.util.Map;

import static org.pawtropoliscity.game.entity.Player.player;

public class CommandController {
        private static CommandController instance = null;
        private final Bag bag = new Bag();
    private final MoveController moveController = MoveController.getInstance();

        private final Map<String, Runnable> commandMapper = new HashMap<>();

        public static CommandController getInstance(){
            if (instance == null){
                instance = new CommandController();
            }
            return instance;
        }
        public void printCurrentSlotsLeft(){
            System.out.printf("Slots left: %s%n%n", bag.getSlotsCapacity());
        }

        private void printNotEnoughSpace(){
            System.out.println("Not enough space\n");
        }

        private void printNoItem(){
            System.out.println("Item not found\n");
        }

        private void printInvalidCommand(){
            System.out.println("Invalid command\n");
        }
        private void printHelpCommandsMessage() {
          System.out.println("""
                these are all commands:\s
                👀look
                👜bag
                🏃‍♀️go <choose direction> example -> 1)go north OR 2)go north_east
                🗑️drop <name item>
                🛒get <name item>
                exit""");


    }

    public void isExit(){
            GameController.exit = !GameController.exit;
    }


    public void locateCommand(String command){
            Map<String,String> commandItemMap = stringConverter(command);
            commandMapper.put("go", () -> moveController.executeCommand(command));
            commandMapper.put("get", ()-> getItem(commandItemMap.get("get")));
            commandMapper.put("drop", () -> dropItem(commandItemMap.get("drop")));
            commandMapper.put("look", this::lookRoom);
            commandMapper.put("bag", this::lookBag);
            commandMapper.put("help", this::printHelpCommandsMessage);
            commandMapper.put("exit", this::isExit);

        executeCommand(command);
    }
    
    public void executeCommand(String command){
        Map<String,String> commandItemMap = stringConverter(command);
        String lastKey = null;
        for (String key : commandItemMap.keySet()) {
            lastKey = key;
        }
        Runnable execute = commandMapper.get(lastKey);
        if(execute != null) {
            execute.run();
            printCurrentSlotsLeft();
        } else{
            printInvalidCommand();
        }
    }

    public Map<String, String> stringConverter(String command){
        String[] splitCommand = command.split(" ");
        String nameItem = splitCommand[splitCommand.length -1];
        String actionCommand = splitCommand[0];
        Map<String,String> commandItemMap= new HashMap<>();
        commandItemMap.put(actionCommand, nameItem);
            return commandItemMap;
    }

        public void getItem(String name){
            Item item = MapController.roomMap.get(player.getCoordinate()).getItemFromRoom(name);

            if (MapController.roomMap.get(player.getCoordinate()).containsItemInRoom(item)){
                if (bag.canFitInBag(item)){
                    bag.addItem(item);
                    MapController.roomMap.get(player.getCoordinate()).removeItem(item);
                    bag.decrementCurrentSlotsCapacity(item);
                }else {
                    printNotEnoughSpace();
                }
            }else {
                printInvalidCommand();
            }
        }

        public void dropItem(String name){
            Item item = bag.getItemFromBag(name);

            if (bag.containsItemInBag(item)){
                MapController.roomMap.get(player.getCoordinate()).addItem(item);
                bag.removeItem(item);
                bag.incrementCurrentSlotsCapacity(item);
            }else {
                printNoItem();
            }
        }

        public void lookRoom(){
            MapController.roomMap.get(player.getCoordinate()).printItems();
            MapController.roomMap.get(player.getCoordinate()).printAnimals();

        }

        public void lookBag(){
            bag.printItems();
        }



}

