package mk.ukim.finki.emt.patient.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.patient.domain.models.PatientType;

import javax.validation.constraints.NotNull;

@Data
public class PatientForm {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String patientNHI;
    @NotNull
    private PatientType patientType;

}
