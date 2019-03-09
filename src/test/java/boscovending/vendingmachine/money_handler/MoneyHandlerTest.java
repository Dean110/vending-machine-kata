package boscovending.vendingmachine.money_handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyHandlerTest {
    MoneyHandler underTest;

    @BeforeEach
    void setup() {
        underTest = new MoneyHandler();
    }

    @Test
    void coinHopperShouldHaveAZeroBalanceWithNoCoinsDeposited() {
        BigDecimal balance = underTest.getBalance();
        assertThat(balance).isEqualTo("0.00");
    }


}
