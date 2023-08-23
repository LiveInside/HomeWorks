package org.homeworks;

import org.homeworks.collections.HomeWorkAdvancedStreams;
import org.homeworks.collections.HomeWorkSets;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "Yes", "two", 2, "four", 4)
        );

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", 2, "three", 1, "four", true)
        );

        System.out.println(HomeWorkSets.genDiff(data1, data2));
    }
}