import org.homeworks.collections.HomeWorkLists;
import org.homeworks.collections.HomeWorkMaps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
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

}