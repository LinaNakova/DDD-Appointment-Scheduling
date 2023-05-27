package mk.ukim.finki.emt.appointmentmanagement.service.impl;

import mk.ukim.finki.emt.appointmentmanagement.domain.exception.AppointmentItemIdNotExistsException;
import mk.ukim.finki.emt.appointmentmanagement.domain.exception.AppointmentItemNotExistsException;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentItemId;
import mk.ukim.finki.emt.appointmentmanagement.domain.repository.AppointmentRepository;
import mk.ukim.finki.emt.appointmentmanagement.service.AppointmentService;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentItemForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentId bookAppointment(AppointmentForm form) {
        Objects.requireNonNull(form, "appointment must not be null");
        var appointment = this.toDomainObject(form);
        var newAppointment = appointmentRepository.saveAndFlush(appointment);
        return newAppointment.getId();
    }

    private Appointment toDomainObject(AppointmentForm form){
        var appointment = new Appointment(form.getCurrency());
        form.getItems().forEach(item -> appointment.addItem(item.getPatient(), item.getCoveredByInsurance(), item.getAppointmentSchedule(), item.getAppointmentType(), item.getPrice()));
        return appointment;
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(AppointmentId appointmentId) {
        return this.appointmentRepository.findById(appointmentId);
    }

    @Override
    public void addItem(AppointmentId appointmentId, AppointmentItemForm appointmentItemForm) throws AppointmentItemNotExistsException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(AppointmentItemIdNotExistsException::new);
        appointment.addItem(appointmentItemForm.getPatient(), appointmentItemForm.getCoveredByInsurance(),
                appointmentItemForm.getAppointmentSchedule(), appointmentItemForm.getAppointmentType(), appointmentItemForm.getPrice());
        appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public void deleteItem(AppointmentId appointmentId, AppointmentItemId appointmentItemId) throws AppointmentItemNotExistsException, AppointmentItemIdNotExistsException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(AppointmentItemIdNotExistsException::new);
        appointment.removeItem(appointmentItemId);
        appointmentRepository.saveAndFlush(appointment);
    }
}
