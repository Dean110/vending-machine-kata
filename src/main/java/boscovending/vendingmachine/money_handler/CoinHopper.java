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
        switch (coin){
            case QUARTER:
                balance = balance.add(BigDecimal.valueOf(25, 2));
                break;
            case NICKEL:
                balance = balance.add(BigDecimal.valueOf(5, 2));
                break;
            case DIME:
                balance = balance.add(BigDecimal.valueOf(10,2));
        }
    }

    public void returnCoins() {
        balance = new BigDecimal("0.00");
    }
}
