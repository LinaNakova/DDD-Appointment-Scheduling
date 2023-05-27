package mk.ukim.finki.emt.appointmentmanagement.domain.repository;

import mk.ukim.finki.emt.appointmentmanagement.domain.model.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
}
