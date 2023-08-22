package org.homeworks.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.stream.Stream;

public class HomeWorksLambdas {
    public static List<String> takeOldestMans(final List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(user -> LocalDate.parse(user.get("birthday"))))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }

    public static String[][] enlargeArrayImage(final String[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        return Arrays.stream(image)
                .flatMap(row -> Stream.of(row, row))
                .map(row -> Arrays.stream(row)
                        .flatMap(pixel -> Stream.of(pixel, pixel))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
