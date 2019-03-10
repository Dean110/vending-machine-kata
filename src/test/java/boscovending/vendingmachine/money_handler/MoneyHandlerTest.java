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
    @DisplayName("MoneyHandler processes different coins and adjusts the coin hopper balance accordingly.")
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
        depositCoins(coins);
        assertedBalance(expectedBalance);
    }

    private void depositCoins(Coin... coins) {
        List<Coin> coinsForDeposit = Arrays.asList(coins);
        coinsForDeposit.forEach(underTest::insertCoin);
    }

    private void assertedBalance(String expectedValue) {
        BigDecimal balance = underTest.getDepositBalance();
        assertThat(balance).isEqualTo(expectedValue);
    }
    @Test
    @DisplayName("MoneyHandler resets the balance when return coins is pressed.")
    void returnCoinsEmptiesTheCoinHopperAndResetsTheBalance(){
        depositCoins(NICKEL,DIME,DIME);
        underTest.returnCoins();
        assertedBalance("0.00");
    }
    @Test
    @DisplayName("MoneyHandler returns inserted coins to the coin return when return coins is pressed.")
    void returnCoins_DimeDeposited_ReturnsTheDimeThatIsDeposited(){
        Coin depositedCoin = DIME;
        depositCoins(depositedCoin);
        underTest.returnCoins();
        List<Coin> result = underTest.checkCoinReturn();
        assertThat(result).containsExactlyInAnyOrder(depositedCoin);
    }
    @Test
    @DisplayName("MoneyHandler sends deposited slugs to the coin return.")
    void slugsAreReturnedToTheCoinReturn(){
        depositCoins(SLUG);
        List<Coin> result = underTest.checkCoinReturn();
        assertThat(result).containsExactlyInAnyOrder(SLUG);
    }
}
