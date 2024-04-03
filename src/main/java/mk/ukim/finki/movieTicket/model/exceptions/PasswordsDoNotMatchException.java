package mk.ukim.finki.movieTicket.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match.");
    }

}
