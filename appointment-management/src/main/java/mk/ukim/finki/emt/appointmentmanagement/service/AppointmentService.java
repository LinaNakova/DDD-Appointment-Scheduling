package mk.ukim.finki.emt.appointmentmanagement.service;

import mk.ukim.finki.emt.appointmentmanagement.domain.exception.AppointmentItemIdNotExistsException;
import mk.ukim.finki.emt.appointmentmanagement.domain.exception.AppointmentItemNotExistsException;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentItemId;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.appointmentmanagement.service.forms.AppointmentItemForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    AppointmentId bookAppointment(AppointmentForm form);

    List<Appointment> findAllAppointments();

    Optional<Appointment> findById(AppointmentId appointmentId);

    void addItem(AppointmentId appointmentId, AppointmentItemForm appointmentItemForm) throws AppointmentItemNotExistsException;

    void deleteItem(AppointmentId appointmentId, AppointmentItemId appointmentItemId) throws AppointmentItemNotExistsException, AppointmentItemIdNotExistsException;
}
