public class Sequence {
    public Sequence(String value) throws TooShortSequence, InvalidCharacter {
        isLongEnough(value);

        containsOnlyValidCharacters(value);
    }

    private static void containsOnlyValidCharacters(String value) throws InvalidCharacter {
        if (!value.matches("[RL]+")) {

            throw new InvalidCharacter();
        }
    }

    private static void isLongEnough(String value) throws TooShortSequence {
        if (value.length() < 2) {
            throw new TooShortSequence();
        }
    }
}
