package mk.ukim.finki.emt.appointmentmanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects.PatientId;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Entity
@Table(name = "appointment_item")
public class AppointmentItem extends AbstractEntity<AppointmentItemId> {
    @Embedded
    private Money price;
    @Embedded
    @AttributeOverride(name="id", column = @Column(name="patient_id", nullable = false))
    private PatientId patient;
    private Boolean coveredByInsurance;
    private LocalDateTime appointmentSchedule;
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;


    public  AppointmentItem(@NotNull PatientId patientId, @NotNull  Boolean coveredByInsurance, @NotNull  LocalDateTime appointmentSchedule,
                            @NotNull AppointmentType appointmentType, @NotNull Money price){
        super(DomainObjectId.randomId(AppointmentItemId.class));
        this.patient = patientId;
        this.coveredByInsurance = coveredByInsurance;
        this.appointmentSchedule = appointmentSchedule;
        this.appointmentType = appointmentType;
        this.price = price;
    }

    public AppointmentItem() {

    }

    public PatientId getPatient() {
        return patient;
    }

    public Money getPrice() {
        return price;
    }

    public Money subtotal(){
        if (coveredByInsurance){
            return new Money(price.getCurrency(), price.getAmount() - price.getAmount()*0.8);
        }
        else {
            return price;
        }
    }
}
