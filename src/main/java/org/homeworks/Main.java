package org.homeworks;

import org.homeworks.collections.HomeWorkAdvancedStreams;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) throws IOException {
        String content = Files.readString(Path.of("s.conf"));

        String result = HomeWorkAdvancedStreams.getForwardedVariables1(content);

        System.out.println(result);
    }
}