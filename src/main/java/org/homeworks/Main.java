package org.homeworks;

import org.homeworks.collection.HomeWorkLists;

public class Main {
    public static void main(final String[] args) {
        System.out.println(HomeWorkLists.scrabble("rkqodlw", "world"));
        System.out.println(HomeWorkLists.scrabble("ajv", "java"));
        System.out.println(HomeWorkLists.scrabble("avjafff", "JaVa"));
        System.out.println(HomeWorkLists.scrabble("", "hexlet"));
    }
}