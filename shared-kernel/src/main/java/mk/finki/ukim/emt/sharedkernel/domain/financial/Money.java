package mk.finki.ukim.emt.sharedkernel.domain.financial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Money implements ValueObject {
    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private final double amount;

    protected Money(){
        this.amount = 0.0;
        this.currency = null;
    }

    public Money(@NonNull Currency currency, @NonNull double amount){
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, double amount){
        return new Money(currency, amount);
    }

    public Money add(Money money){
        if (!currency.equals(money.currency)){
            throw new IllegalArgumentException("Cannot add two currencies from different amounts");
        }
        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money){
        if (!currency.equals(money.currency)){
            throw new IllegalArgumentException("Cannot add two currencies from different amounts");
        }
        return new Money(currency, amount - money.amount);
    }

    public Money multiply(int m){
        return new Money(currency, amount*m);
    }
}
