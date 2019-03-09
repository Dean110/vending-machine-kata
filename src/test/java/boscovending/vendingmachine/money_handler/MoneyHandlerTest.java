package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyHandlerTest {
    MoneyHandler underTest;

    @BeforeEach
    void setup() {
        underTest = MoneyHandlerFactory.createMoneyHandler();
    }

    @Test
    void moneyHandlerShouldHaveAZeroBalanceWithNoCoinsDeposited() {
        assertedBalance("0.00");
    }

    @Test
    void moneyHandlerShouldHaveA25CentBalanceWithOneQuarterDeposited(){
        underTest.insertCoin(Coin.QUARTER);
        assertedBalance("0.25");
    }

    private void assertedBalance(String expectedValue) {
        BigDecimal balance = underTest.getDepositBalance();
        assertThat(balance).isEqualTo(expectedValue);
    }


}
