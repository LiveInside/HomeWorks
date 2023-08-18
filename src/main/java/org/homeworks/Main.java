package org.homeworks;

import org.homeworks.collections.HomeWorkMaps;

import java.util.Map;

public class Main {
    public static void main(final String[] args) {
        Map<String, Integer> wordsCount = HomeWorkMaps
                .getWordCount("the Java is the best programming language java");
        System.out.println(wordsCount.size());
        System.out.println(HomeWorkMaps.toString(wordsCount));
    }
}
