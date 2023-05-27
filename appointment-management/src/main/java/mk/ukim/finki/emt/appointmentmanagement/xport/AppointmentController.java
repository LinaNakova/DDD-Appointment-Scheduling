package mk.ukim.finki.emt.appointmentmanagement.xport;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @GetMapping
    private List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }
}
