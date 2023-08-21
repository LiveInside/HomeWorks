import org.homeworks.collections.HomeWorkGenerics;
import org.homeworks.collections.HomeWorkLists;
import org.homeworks.collections.HomeWorkMaps;
import org.homeworks.collections.HomeWorkTests;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


class TestHomeWorks {
    // Тесты HomeWorkLists
    @Test
    public void testScrabble() {
        assertThat(HomeWorkLists.scrabble("rkqodlw", "world")).isTrue();
        assertThat(HomeWorkLists.scrabble("ajv", "java")).isFalse();
        assertThat(HomeWorkLists.scrabble("avjafff", "JaVa")).isTrue();
        assertThat(HomeWorkLists.scrabble("", "hexlet")).isFalse();
        assertThat(HomeWorkLists.scrabble("abcde", "ace")).isTrue();
    }
    // Тесты HomeWorkMaps
    @Test
    public void testGetWordCount() {
        Map<String, Integer> wordsCount = HomeWorkMaps
                .getWordCount("The, Java is... the best /programming language java!");

        assertThat(wordsCount).hasSize(6);
        assertThat(wordsCount)
                .containsKey("the")
                .containsKey("java")
                .containsKey("is")
                .containsKey("best")
                .containsKey("language")
                .containsKey("programming");

        assertThat(wordsCount.get("the")).isEqualTo(2);
        assertThat(wordsCount.get("java")).isEqualTo(2);
        assertThat(wordsCount.get("is")).isEqualTo(1);
        assertThat(wordsCount.get("best")).isEqualTo(1);
        assertThat(wordsCount.get("language")).isEqualTo(1);
        assertThat(wordsCount.get("programming")).isEqualTo(1);
    }
    @Test
    public void testToString() {
        Map <String, Integer> emptyMap = new HashMap<>();

        assertThat(HomeWorkMaps.toString(emptyMap)).isEqualTo("{\n}");

        Map<String, Integer> wordsCount = HomeWorkMaps
                .getWordCount("The, Java is... the best /programming language java!");

        assertThat(HomeWorkMaps.toString(wordsCount)).isEqualTo("""
                {
                  the: 2
                  java: 2
                  is: 1
                  best: 1
                  language: 1
                  programming: 1
                }""");
    }
    // Тесты "HomeWorkGenerics
    @Test
    void testFindWhere() {
        Map<String, String> condition = new HashMap<>();
        condition.put("author", "J.K. Rowling");
        condition.put("genre", "Fantasy");

        Map<String, String> book1 = new HashMap<>();
        book1.put("title", "Harry Potter");
        book1.put("author", "J.K. Rowling");
        book1.put("genre", "Fantasy");

        Map<String, String> book2 = new HashMap<>();
        book2.put("title", "The Lord of the Rings");
        book2.put("author", "J.R.R. Tolkien");
        book2.put("genre", "Fantasy");

        Map<String, String> book3 = new HashMap<>();
        book3.put("title", "The Catcher in the Rye");
        book3.put("author", "J.D. Salinger");
        book3.put("genre", "Fiction");

        List<Map<String, String>> books = Arrays.asList(book1, book2, book3);

        List<Map<String, String>> result = HomeWorkGenerics.findWhere(books, condition);

        assertThat(result).containsExactly(book1);

        // Нет совпадений
        Map<String, String> conditionEmpty = new HashMap<>();
        condition.put("author", "J.K. Rowling");
        condition.put("genre", "Fantasy");

        Map<String, String> book1Empty = new HashMap<>();
        book1.put("title", "The Lord of the Rings");
        book1.put("author", "J.R.R. Tolkien");
        book1.put("genre", "Fantasy");

        Map<String, String> book2Empty = new HashMap<>();
        book2.put("title", "The Catcher in the Rye");
        book2.put("author", "J.D. Salinger");
        book2.put("genre", "Fiction");

        List<Map<String, String>> booksEmpty = Arrays.asList(book1Empty, book2Empty);

        List<Map<String, String>> resultEmpty = HomeWorkGenerics.findWhere(booksEmpty, conditionEmpty);

        assertThat(resultEmpty).isEmpty();
    }
    // Тесты HomeWorkTests
    @Test
    void testTake() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> correctlyRes1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> correctlyRes2 = new ArrayList<>(Arrays.asList(7, 3, 10));

        assertThat(HomeWorkTests.take(numbers, 3)).isEmpty();
        assertThat(HomeWorkTests.take(numbers1, 0)).isEmpty();
        assertThat(HomeWorkTests.take(numbers1, 2)).isEqualTo(correctlyRes1);
        assertThat(HomeWorkTests.take(numbers2, 8)).isEqualTo(correctlyRes2);
    }
}