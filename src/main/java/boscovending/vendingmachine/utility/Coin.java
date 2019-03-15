package boscovending.vendingmachine.utility;

import lombok.Getter;

import java.math.BigDecimal;
public enum Coin {
    NICKEL("0.05"), DIME("0.10"), SLUG("0.00"), QUARTER("0.25");
    @Getter
    BigDecimal value;
    Coin(String value) {
        this.value = new BigDecimal(value);
    }
}
