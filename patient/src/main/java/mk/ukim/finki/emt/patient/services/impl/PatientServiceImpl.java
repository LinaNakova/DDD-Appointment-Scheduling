package mk.ukim.finki.emt.patient.services.impl;

import mk.ukim.finki.emt.patient.domain.exception.PatientNotExistsException;
import mk.ukim.finki.emt.patient.domain.models.Patient;
import mk.ukim.finki.emt.patient.domain.models.PatientId;
import mk.ukim.finki.emt.patient.domain.repository.PatientRepository;
import mk.ukim.finki.emt.patient.services.PatientService;
import mk.ukim.finki.emt.patient.services.forms.PatientForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(PatientForm form) {
       Patient patient = Patient.build(form.getPatientNHI(), form.getFirstName(), form.getLastName(), form.getPatientType());
       this.patientRepository.save(patient);
       return patient;
    }

    @Override
    public Patient findById(PatientId patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(PatientNotExistsException::new);
    }

}
