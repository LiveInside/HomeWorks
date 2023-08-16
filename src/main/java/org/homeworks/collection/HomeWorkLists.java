package org.homeworks.collection;

import java.util.LinkedList;

public class HomeWorkLists {
    // Урок "Коллекции"
    public static boolean scrabble(final String letters, final String word) {
        LinkedList<Character> stackLetters = new LinkedList<>();

        for (char letter : letters.toLowerCase().toCharArray()) {
            stackLetters.push(letter);
        }
        System.out.println(stackLetters.peek());

        for (char letter : word.toLowerCase().toCharArray()) {
            if (!stackLetters.removeFirstOccurrence(letter)) {
                return false;
            }
        }

        return true;
    }
}
