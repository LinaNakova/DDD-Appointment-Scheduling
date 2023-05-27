package mk.ukim.finki.emt.patient.domain.exception;

public class PatientNotExistsException extends RuntimeException{
    public PatientNotExistsException(){
        super("Patient doesn't exist");
    }
}
