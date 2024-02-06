package org.pawtropoliscity.game.factory;

import org.pawtropoliscity.game.entity.Item;
import org.pawtropoliscity.game.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    private static ItemFactory instance = null;

    private ItemFactory(){}

    public static ItemFactory getInstance() {
        if( instance == null) {
            instance = new ItemFactory();
        }
        return instance;
    }

    private final Random random = new Random();

    private final List<Item> itemList = List.of(
            new Item("Torch", "is a torch", 5),
            new Item("Sword", "is a sword", 7),
            new Item("Helmet", "is a helmet", 4),
            new Item("Ball", "is a ball", 2),
            new Item("Collar", "is a collar", 3),
            new Item("Poison", "is a poison", 10)
    );

    public List<Item> createRandomItemList(){
        int numIterator = random.nextInt(1, 6);
        List<Item> randomItemList = new ArrayList<>();

        for (int i = 0; i < numIterator; i++){
            int selectedIndex = random.nextInt(itemList.size());
            Item item = itemList.get(selectedIndex);
            randomItemList.add(item);
        }
        return randomItemList;
    }
}
