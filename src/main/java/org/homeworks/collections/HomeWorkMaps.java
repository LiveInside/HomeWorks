package org.homeworks.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HomeWorkMaps {
    // Урок "Словари"
    public static Map<String, Integer> getWordCount(final String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        return wordsMap;
    }

    public static String toString(final Map<String, Integer> wordsMap) {
        Set<String> keys = wordsMap.keySet();
        StringBuilder str = new StringBuilder("{\n");

        for (String key : keys) {
            str.append("  ")
                    .append(key)
                    .append(": ")
                    .append(wordsMap.get(key))
                    .append("\n");
        }
        str.append("}");
        return str.toString();
    }

}
