package org.pawtropoliscity.game.controller;

import org.pawtropoliscity.game.entity.Bag;
import org.pawtropoliscity.game.entity.Item;

import java.util.List;

import static org.pawtropoliscity.game.entity.Player.player;

public class CommandController {
        private static CommandController instance = null;
        private final Bag bag = new Bag();

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


        public void getItem(String name){
            Item item = MapController.roomMap.get(player.getCoordinate()).getItemFromRoom(name);

            if (MapController.roomMap.get(player.getCoordinate()).containsItemInRoom(item)){
                if (bag.canFitInBag(item)){
                    bag.addItem(item);
                    MapController.roomMap.get(player.getCoordinate()).removeItem(item);
                    bag.decrementSlotsCapacity(item);
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
                bag.incrementSlotsCapacity(item);
            }else {
                printNoItem();
            }
        }

        public void lookRoom(){
            lookItemInRoom();
            lookAnimalInRoom();
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

    public void lookItemInRoom(){
        List<String> roomItems = MapController.roomMap.get(player.getCoordinate()).getRoomItems();
        String result = "Items: " + String.join(", ", roomItems);

        if (!roomItems.isEmpty()) {
            result += ".";
        } else {
            result += "you don't have items";
        }

        System.out.println(result);
    }

    public void lookAnimalInRoom(){
        List<String> roomAnimals = MapController.roomMap.get(player.getCoordinate()).getRoomAnimals();
        String result = "NPC: " + String.join(", ", roomAnimals);

        if (!roomAnimals.isEmpty()) {
            result += ".";
        } else {
            result += "you don't have items";
        }

        System.out.println(result);
    }

    }

