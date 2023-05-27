package mk.ukim.finki.emt.appointmentmanagement.service.forms;

import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AppointmentForm {
    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<AppointmentItemForm> items = new ArrayList<>();
}
