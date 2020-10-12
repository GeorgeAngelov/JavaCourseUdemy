package com.georgeangelov;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <=100 ; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intesection = new HashSet<>(squares);
        intesection.retainAll(cubes);

        System.out.println("Intersection contains " + intesection.size() + " elements");
        for (int i : intesection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String s : words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> devine = new HashSet<>();
        String[] natureWords = {"all" , "nature", "is", "but", "art", "unknown" , "to", "tree"};
        String[] devineWord = {"to", "err", "is", "human", "to", "forgive", " divine"};

        nature.addAll(Arrays.asList(natureWords));
        devine.addAll(Arrays.asList(devineWord));

        System.out.println("nature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(devine);
        printSet(diff1);

        System.out.println("divine - nature: ");
        Set<String>diff2 = new HashSet<>(devine);
        diff2.removeAll(nature);
        printSet(diff2);


        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(devine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(devine);

        System.out.println("Symetric diff: ");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(devine)){
            System.out.println("devine is a subset of nature");
        }
        if (nature.containsAll(intersectionTest)){
            System.out.println("intersection is a subset of nature");
        }
        if (devine.containsAll(intersectionTest)){
            System.out.println("intersection is a subset of devine");
        }
    }

    private static void printSet(Set<String> set){
        System.out.println("\t");
        for (String s : set){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
