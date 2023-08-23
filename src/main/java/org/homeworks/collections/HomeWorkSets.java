package org.homeworks.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWorkSets {
    // первый вариант
    public static <T> LinkedHashMap<String, String> genDiff(Map<String, T> data1, Map<String, T> data2) {
        Set<String> data1Keys = new HashSet<>(data1.keySet());
        Set<String> data2Keys = new HashSet<>(data2.keySet());

        // нету в 1 массиве
        Set<String> added = data2Keys.stream()
                .filter(key -> !data1Keys.contains(key))
                .collect(Collectors.toSet());

        // нету во 2 массиве Сразу в мапу?
        Set<String> deleted = data1Keys.stream()
                .filter(key -> !data2Keys.contains(key))
                .collect(Collectors.toSet());

        Set<String> changed = data1Keys.stream()
                .filter(data2Keys::contains)
                .filter(key -> !data1.get(key).equals(data2.get(key)))
                .collect(Collectors.toSet());

        Set<String> unchanged = data1Keys.stream()
                .filter(data2Keys::contains)
                .filter(key -> data1.get(key).equals(data2.get(key)))
                .collect(Collectors.toSet());

        Map<String, String> keyDifferences = new LinkedHashMap<>();

        for (String key : deleted) {
            keyDifferences.put(key, "deleted");
        }
        for (String key : added) {
            keyDifferences.put(key, "added");
        }
        for (String key : changed) {
            keyDifferences.put(key, "changed");
        }
        for (String key : unchanged) {
            keyDifferences.put(key, "unchanged");
        }

        return keyDifferences.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(),
                        entry.getValue()), LinkedHashMap::putAll);
    }

    // второй вариант
//    public static <T> LinkedHashMap<String, String> genDiff2(Map<String, T> data1, Map<String, T> data2) {
//        Set<String> data1Keys = data1.keySet();
//        Set<String> data2Keys = data2.keySet();
//
//        Set<String> added = data2Keys.stream()
//                .filter(key -> !data1Keys.contains(key))
//                .collect(Collectors.toSet());
//
//        Set<String> deleted = data1Keys.stream()
//                .filter(key -> !data2Keys.contains(key))
//                .collect(Collectors.toSet());
//
//        Map<String, String> keyDifferences = Stream.concat(
//                        Stream.concat(added.stream(), deleted.stream()),
//                        data1Keys.stream().filter(data2Keys::contains))
//                .collect(Collectors.toMap(
//                        key -> key,
//                        key -> {
//                            T value1 = data1.get(key);
//                            T value2 = data2.get(key);
//                            return Objects.equals(value1, value2) ? "unchanged" : "changed";
//                        }
//                ));
//
//        return keyDifferences.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue,
//                        LinkedHashMap::new
//                ));
//    }
}