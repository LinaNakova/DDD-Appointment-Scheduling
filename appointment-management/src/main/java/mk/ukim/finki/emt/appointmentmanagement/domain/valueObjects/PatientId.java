package mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class PatientId extends DomainObjectId {

    public PatientId() {
        super(PatientId.randomId(PatientId.class).getId());
    }

    public PatientId(String uuid) {
        super(uuid);
    }

}
