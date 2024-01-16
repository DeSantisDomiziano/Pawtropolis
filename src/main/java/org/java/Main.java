package org.java;

import org.java.animals.abst.AnimalWithTail;
import org.java.animals.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Zoo zoo = Zoo.getInstance();





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