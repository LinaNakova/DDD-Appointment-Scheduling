package mk.ukim.finki.emt.patient.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity<PatientId> {
    private String patientNHI;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private PatientType patientType;

    public Patient() {
        super(PatientId.randomId(PatientId.class));
    }

    public static Patient build(String patientNHI, String firstName, String lastName, PatientType patientType){
        Patient patient = new Patient();
        patient.patientNHI = patientNHI;
        patient.patientType = patientType;
        patient.firstName = firstName;
        patient.lastName = lastName;

        return patient;
    }

}
