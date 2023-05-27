package mk.ukim.finki.emt.appointmentmanagement.domain.model;

import jakarta.persistence.*;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueObjects.Patient;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "appointment")
public class Appointment extends AbstractEntity<AppointmentId> {
    @Enumerated(EnumType.STRING)
    private AppointmentState appointmentState;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AppointmentItem> appointmentItemList;

    @Column(name = "appointment_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Appointment(){
        super(AppointmentId.randomId(AppointmentId.class));
    }

    public Appointment(Currency currency){
        this.currency = currency;
        this.appointmentItemList = new HashSet<>();
    }

    public Money total(){
        return appointmentItemList.stream()
                .map(AppointmentItem::subtotal)
                .reduce(new Money(currency, 0), Money::add);
    }

    public AppointmentItem addItem(@NotNull Patient patient, @NotNull  Boolean coveredByInsurance, @NotNull  LocalDateTime appointmentSchedule,
                                   @NotNull AppointmentType appointmentType, @NotNull Money price){
        Objects.requireNonNull(patient, "Patient must not be null");
        var item = new AppointmentItem(patient.getId(), coveredByInsurance, appointmentSchedule, appointmentType, price);
        this.appointmentItemList.add(item);
        return item;
    }

    public void removeItem(@NotNull AppointmentItemId appointmentItemId){
        Objects.requireNonNull(appointmentItemId, "Patient must not be null");
        appointmentItemList.removeIf( v-> v.getId().equals(appointmentItemId));
    }


}
