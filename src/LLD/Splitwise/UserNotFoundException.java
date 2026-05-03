package LLD.Splitwise;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message) {
        super(message);
    }
}
