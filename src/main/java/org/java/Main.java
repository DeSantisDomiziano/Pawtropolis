package org.java;

import org.java.animals.abst.AnimalWithTail;
import org.java.animals.entity.Eagle;
import org.java.animals.entity.Lion;
import org.java.animals.entity.Tiger;
import org.java.animals.entity.Zoo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Zoo zoo = Zoo.getInstance();


        Tiger t1 = new Tiger("Sid", "eagle", 3, LocalDate.now(), 100.75f,130, 30);
        Tiger t2 = new Tiger("Gino", "pony", 5, LocalDate.now(), 150.3f,140, 55);
        Tiger t3 = new Tiger("George", "cat", 3, LocalDate.now(), 154.5f,144, 39);

        Lion l1 = new Lion("Alex", "zebra", 6, LocalDate.now(), 80.8f, 110,40);
        Lion l2 = new Lion("Manny", "dog", 2, LocalDate.now(), 63.8f, 94,32);
        Lion l3 = new Lion("Annarella", "human", 4, LocalDate.now(), 87.8f, 122,46);

        Eagle e1 = new Eagle("Spirit", "worm", 4, LocalDate.now(), 22.35f, 60, 62);
        Eagle e2 = new Eagle("Bomber", "balls", 2, LocalDate.now(), 20.3f, 54, 55);
        Eagle e3 = new Eagle("Fulvio", "other", 5, LocalDate.now(), 23.35f, 62, 59);

        zoo.addAnimal(t1);
        zoo.addAnimal(t2);
        zoo.addAnimal(t3);

        zoo.addAnimal(l1);
        zoo.addAnimal(l2);
        zoo.addAnimal(l3);

        zoo.addAnimal(e1);
        zoo.addAnimal(e2);
        zoo.addAnimal(e3);

        System.out.println(zoo.getLongestTailByClass(AnimalWithTail.class));

        /*
        zoo.getAnimalsByClass(Tiger.class).forEach(System.out::println);

        // TODO cerchiamo di far compilare il codice qua sotto
        ArrayList<Lion> arrayListLion = new ArrayList<>(zoo.getAnimalsByClass(Lion.class));
        arrayListLion.forEach(System.out::println);

        Lion haviestLion = zoo.getHeaviestByClass(Lion.class);
        System.out.println(haviestLion);

        Lion tallestLion = zoo.getTallestByClass(Lion.class);
        System.out.println(tallestLion);

        System.out.println(zoo.getLongestTailByClass(Tiger.class));

        System.out.println(zoo.getLongestWingsSpan(Eagle.class));

        Eagle lightestEagle = zoo.getLightestByClass(Eagle.class);
        System.out.println(lightestEagle);

        Tiger shortestTiger = zoo.getShortestByClass(Tiger.class);
        System.out.println(shortestTiger);
        */

    }
}