package boscovending.vendingmachine.moneyHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinHopperTest {
    CoinHopper underTest;

    @BeforeEach
    void setup() {
        underTest = new CoinHopper();
    }

    @Test
    void coinHopperShouldHaveAZeroBalanceWithNoCoinsDeposited() {
        BigDecimal balance = underTest.getBalance();
        assertThat(balance).isEqualTo("0.00");
    }


}
