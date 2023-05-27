package mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;
@Getter
public class Patient implements ValueObject {

    private final PatientId id;
    private final String firstName;
    private final String lastName;
    private final String patientNHI;

    private Patient() {
        this.id = PatientId.randomId(PatientId.class);
        this.firstName = "";
        this.lastName = "";
        this.patientNHI = "";
    }

    @JsonCreator
    public Patient(PatientId id, String firstName, String lastName, String patientNHI) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientNHI = patientNHI;
    }
}
