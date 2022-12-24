package dians.finki.ukim.mk.lab.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException(){
        super("Bad credentials.");
    }
}
