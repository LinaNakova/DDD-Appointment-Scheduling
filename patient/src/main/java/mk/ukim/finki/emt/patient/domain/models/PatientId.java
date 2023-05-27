package mk.ukim.finki.emt.patient.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class PatientId extends DomainObjectId {
    protected PatientId(@NonNull String uuid) {
        super(uuid);
    }
}
