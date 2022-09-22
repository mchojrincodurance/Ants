import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SequenceShould {

    @ParameterizedTest
    @CsvSource({
            "''",
            "A",
    })
    void not_accept_less_than_two_characters(String sequenceStr) {
        Assertions.assertThrows(TooShortSequence.class, () -> {
            new Sequence(sequenceStr);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "LL",
            "LLL",
            "LLLL",
    })
    public void accept_more_than_one_character(String sequenceStr) {
        Assertions.assertDoesNotThrow(() -> {
            new Sequence(sequenceStr);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "AA",
            "AB",
            "A#@1",
            "rl",
            "Rl",
            "LRRr"
    })
    public void not_accept_characters_different_from_R_and_L(String sequenceStr) {
        Assertions.assertThrows(InvalidCharacter.class, () -> {
            new Sequence(sequenceStr);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "RR",
            "LL",
            "RL",
            "RLLLR",
    })
    public void accept_characters_R_or_L(String sequenceStr) {
        Assertions.assertDoesNotThrow(() -> {
            new Sequence(sequenceStr);
        });
    }
}
