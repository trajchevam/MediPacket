package dians.finki.ukim.mk.lab.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException (){
        super("Invalid Username Or Password.");
    }
}
