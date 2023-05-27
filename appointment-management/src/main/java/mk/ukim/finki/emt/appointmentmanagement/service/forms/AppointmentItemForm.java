package mk.ukim.finki.emt.appointmentmanagement.service.forms;

import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.appointmentmanagement.domain.model.AppointmentType;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects.Patient;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AppointmentItemForm {
    @NotNull
    private Patient patient;
    private Money price;
    private Boolean coveredByInsurance = false;
    private LocalDateTime appointmentSchedule = LocalDateTime.now();
    private AppointmentType appointmentType;
}
