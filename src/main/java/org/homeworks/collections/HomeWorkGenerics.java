package org.homeworks.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HomeWorkGenerics {
    public static <T> List<Map<T, T>> findWhere(final List<Map<T, T>> books,
                                                final Map<T, T> where) {
        Set<T> keys = where.keySet();
        List<Map<T, T>> result = new ArrayList<>();

        for (Map<T, T> book : books) {
            boolean flag = true;
            for (T key : keys) {
                if (!where.get(key).equals(book.get(key))) {
                    flag = false;
                    break;
                }
            }
            if (flag && !book.isEmpty()) {
                result.add(book);
            }
        }

        return result;
    }
}
