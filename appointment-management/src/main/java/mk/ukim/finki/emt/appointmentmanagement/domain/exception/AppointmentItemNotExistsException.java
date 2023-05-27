package mk.ukim.finki.emt.appointmentmanagement.domain.exception;

public class AppointmentItemNotExistsException extends RuntimeException{
    public AppointmentItemNotExistsException(){
        super("Appointment Item doesn't exist");
    }
}
