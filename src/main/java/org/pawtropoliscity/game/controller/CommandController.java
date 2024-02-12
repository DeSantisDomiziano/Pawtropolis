package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Bag;
import org.pawtropoliscity.game.entity.Item;

import java.util.List;
import java.util.stream.Collectors;

import static org.pawtropoliscity.game.entity.Player.player;

public class CommandController {
        private static CommandController instance = null;
        private final Bag bag = new Bag(20);

        public static CommandController getInstance(){
            if (instance == null){
                instance = new CommandController();
            }
            return instance;
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


        public Bag getBag() {
            return bag;
        }

        public void getItem(String name){
            Item item = MapController.roomMap.get(player.getCoordinate()).getItemFromRoom(name);

            if (MapController.roomMap.get(player.getCoordinate()).checkItemInRoom(item)){
                if (bag.checkSlotsCapacity(item)){
                    bag.addItem(item);
                    MapController.roomMap.get(player.getCoordinate()).removeItem(item);
                }else {
                    printNotEnoughSpace();
                }
            }else {
                printInvalidCommand();
            }
        }

        public void dropItem(String name){
            Item item = bag.getItemFromBag(name);

            if (bag.checkItemInBag(item)){
                MapController.roomMap.get(player.getCoordinate()).addItem(item);
                bag.removeItem(item);
            }else {
                printNoItem();
            }
        }

        public void lookRoom(){
            MapController.roomMap.get(player.getCoordinate()).printItemList();
            MapController.roomMap.get(player.getCoordinate()).printAnimalList();
        }

        public void lookBag(){
            List<String> bagsItems = bag.getBagsItems();
            String result = "Items: " + String.join(", ", bagsItems);

            if (!bagsItems.isEmpty()) {
                result += ".";
            } else {
                result += "you don't have items";
            }

            System.out.println(result);
        }

    }

