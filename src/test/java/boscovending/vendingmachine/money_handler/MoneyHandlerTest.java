package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static boscovending.vendingmachine.utility.Coin.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("MoneyHandler unit tests:")
public class MoneyHandlerTest {
    private MoneyHandler underTest;

    @BeforeEach
    void setup() {
        underTest = MoneyHandlerFactory.createMoneyHandler();
    }

    @Test
    @DisplayName("The MoneyHandler processes different coins and adjusts the coin hopper balance accordingly.")
    void insertCoin_CoinsOfDifferentValues_AffectsCoinHopperBalance() {
        assertAll("Inserted coins should affect the balance according to their value.",
                () -> testDepositedCoinsAffectBalance("0.00"),
                () -> testDepositedCoinsAffectBalance("0.25", QUARTER),
                () -> testDepositedCoinsAffectBalance("0.05", NICKEL),
                () -> testDepositedCoinsAffectBalance("0.10", DIME),
                () -> testDepositedCoinsAffectBalance("0.00", SLUG),
                () -> testDepositedCoinsAffectBalance("0.40", NICKEL, DIME, QUARTER)
        );
    }

    private void testDepositedCoinsAffectBalance(String expectedBalance, Coin... coins) {
        underTest = MoneyHandlerFactory.createMoneyHandler();
        List<Coin> coinsForDeposit = Arrays.asList(coins);
        coinsForDeposit.forEach(underTest::insertCoin);
        assertedBalance(expectedBalance);
    }

    private void assertedBalance(String expectedValue) {
        BigDecimal balance = underTest.getDepositBalance();
        assertThat(balance).isEqualTo(expectedValue);
    }

}
