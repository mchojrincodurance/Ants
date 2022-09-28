public class Sequence {
    private final String value;

    public Sequence(String value) throws TooShortSequence, InvalidCharacter {
        isLongEnough(value);

        containsOnlyValidCharacters(value);

        this.value = value;
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

    public char getCommand(int position) {
        return value.charAt(position);
    }
}
