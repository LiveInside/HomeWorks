package org.homeworks.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkAdvancedStreams {

    // Первый вариант
    public static String getForwardedVariables(String content) {
        List<String> listConfig = content.lines()
                .filter(variable -> variable.startsWith("environment"))
                .collect(Collectors.toList());

        String variables = String.join(",", listConfig)
                .trim()
                .replaceAll("environment=", "")
                .replaceAll("\"", "");

        List<String> listVariables = Arrays.stream(variables.split(","))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .collect(Collectors.toList());

        return String.join(",", listVariables)
                .trim()
                .replaceAll("X_FORWARDED_", "");
    }

    //Второй вариант
    public static String getForwardedVariables1(String content) {
       return Arrays.stream(content.split("\n"))
                .filter(variable -> variable.startsWith("environment"))
                .map(variable -> variable.replace("environment=", "")
                        .replace("\"", ""))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
