package mk.ukim.finki.emt.patient.services;

import mk.ukim.finki.emt.patient.domain.models.Patient;
import mk.ukim.finki.emt.patient.domain.models.PatientId;
import mk.ukim.finki.emt.patient.services.forms.PatientForm;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatients();
    Patient createPatient(PatientForm form);
    Patient findById(PatientId patientId);
}
