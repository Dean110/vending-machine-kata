package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;

import java.math.BigDecimal;

public class CoinHopper {

    BigDecimal balance;

    public CoinHopper() {
        balance = new BigDecimal("0.00");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void depositMoney(Coin coin) {
        balance = balance.add(BigDecimal.valueOf(25, 2));
    }
}
