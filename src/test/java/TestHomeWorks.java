import org.assertj.core.api.Assertions;
import org.homeworks.collections.HomeWorkLists;
import org.junit.jupiter.api.Test;


class TestHomeWorks {
    @Test
    public void testScrabble(){
        Assertions.assertThat(HomeWorkLists.scrabble("rkqodlw", "world")).isTrue();
        Assertions.assertThat(HomeWorkLists.scrabble("ajv", "java")).isFalse();
        Assertions.assertThat(HomeWorkLists.scrabble("avjafff", "JaVa")).isTrue();
        Assertions.assertThat(HomeWorkLists.scrabble("", "hexlet")).isFalse();
        Assertions.assertThat(HomeWorkLists.scrabble("abcde", "ace")).isTrue();
    }

}