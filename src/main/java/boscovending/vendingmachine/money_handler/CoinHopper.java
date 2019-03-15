package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoinHopper {

    private BigDecimal balance;
@Getter
    private ArrayList<Coin> hopper;

    public CoinHopper() {
        balance = new BigDecimal("0.00");
        hopper = new ArrayList<>();
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
                hopper.add(coin);
                break;
            case DIME:
                balance = balance.add(BigDecimal.valueOf(10,2));
                hopper.add(coin);
        }
    }

    public void returnCoins() {
        balance = new BigDecimal("0.00");
    }
}
