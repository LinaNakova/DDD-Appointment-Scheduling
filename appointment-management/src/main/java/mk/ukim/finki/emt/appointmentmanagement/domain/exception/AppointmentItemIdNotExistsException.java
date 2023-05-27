package mk.ukim.finki.emt.appointmentmanagement.domain.exception;

public class AppointmentItemIdNotExistsException extends RuntimeException{
    public AppointmentItemIdNotExistsException(){
        super("Appointment Item id doesn't exist");
    }
}
