package mk.ukim.finki.emt.appointmentmanagement.domain.model;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class AppointmentId extends DomainObjectId {
    protected AppointmentId(@NonNull String uuid) {
        super(uuid);
    }
}
