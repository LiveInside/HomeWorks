package org.homeworks.collections;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkTests {
    public static List<Integer> take(final List<Integer> numbers, final int numberOfElem) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numberOfElem && i < numbers.size(); i++) {
            result.add(i, numbers.get(i));
        }
        return result;
    }
}
