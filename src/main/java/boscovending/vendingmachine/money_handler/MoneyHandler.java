package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;

import java.math.BigDecimal;

public class MoneyHandler {
    private CoinHopper coinHopper;

    public MoneyHandler(CoinHopper coinHopper){
        this.coinHopper = coinHopper;
    }


    public BigDecimal getDepositBalance() {
        return coinHopper.getBalance();
    }

    public void insertCoin(Coin coin) {
        coinHopper.depositMoney(coin);
    }
}
