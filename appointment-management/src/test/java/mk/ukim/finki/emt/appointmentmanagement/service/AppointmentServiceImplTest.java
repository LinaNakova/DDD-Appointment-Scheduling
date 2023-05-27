package mk.ukim.finki.emt.appointmentmanagement.service;

import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.appointmentmanagement.domain.exception.ApopintmentIdNotFoundException;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentType;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects.Patient;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects.PatientId;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentItemForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
public class AppointmentServiceImplTest {

    @Autowired
    private AppointmentService appointmentService;



    private static Patient newPatient(String firstName, String lastName, String patientNHI) {
        Patient patient = new Patient(PatientId.randomId(PatientId.class), firstName, lastName, patientNHI);
        return patient;
    }

    @Test
    public void testBookAppointment() {

        AppointmentItemForm appointmentItemForm1 = new AppointmentItemForm();
        appointmentItemForm1.setPatient(newPatient("Lina", "Nakova", "0708001495030"));
        appointmentItemForm1.setAppointmentType(AppointmentType.MENTAL_HEALTH_APPOINTMENT);
        appointmentItemForm1.setAppointmentSchedule(LocalDateTime.now());
        appointmentItemForm1.setCoveredByInsurance(false);
        appointmentItemForm1.setPrice(new Money(Currency.MKD, 3000));


        AppointmentItemForm appointmentItemForm2 = new AppointmentItemForm();
        appointmentItemForm2.setPatient(newPatient("John", "Doe", "0707000490030"));
        appointmentItemForm2.setAppointmentType(AppointmentType.PHYSICAL_THERAPY_APPOINTMENT);
        appointmentItemForm2.setAppointmentSchedule(LocalDateTime.now());
        appointmentItemForm2.setCoveredByInsurance(false);
        appointmentItemForm2.setPrice(new Money(Currency.MKD, 1000));

        AppointmentForm appointmentForm = new AppointmentForm();
        appointmentForm.setCurrency(Currency.MKD);
        appointmentForm.setItems(Arrays.asList(appointmentItemForm1,appointmentItemForm2));

        AppointmentId newAppointmentId = appointmentService.bookAppointment(appointmentForm);
        Appointment newAppointment = appointmentService.findById(newAppointmentId).orElseThrow(ApopintmentIdNotFoundException::new);
        Assertions.assertEquals(newAppointment.total(),Money.valueOf(Currency.MKD,4000));

    }

}
