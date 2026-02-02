package task7;

public class InvalidAgeException extends Exception {
    private int age;
    public InvalidAgeException(String message) {
        super(message);
    }
}

