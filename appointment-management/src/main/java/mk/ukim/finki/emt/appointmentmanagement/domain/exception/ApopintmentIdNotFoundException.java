package mk.ukim.finki.emt.appointmentmanagement.domain.exception;

public class ApopintmentIdNotFoundException extends RuntimeException{
    public ApopintmentIdNotFoundException(){
        super("Appointment Id doesn't exist");
    }
}
