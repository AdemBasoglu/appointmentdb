package be.intecbrussel.exceptions;

public class AppointmentNotFoundException extends Throwable {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
