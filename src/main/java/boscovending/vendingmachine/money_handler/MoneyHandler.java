package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class MoneyHandler {
    private CoinHopper coinHopper;
    private CoinReturn coinReturn;

    public MoneyHandler(CoinHopper coinHopper, CoinReturn coinReturn) {
        this.coinHopper = coinHopper;
        this.coinReturn = coinReturn;
    }


    public BigDecimal getDepositBalance() {
        return coinHopper.getBalance();
    }

    public void insertCoin(Coin coin) {
        coinHopper.depositMoney(coin);
    }

    public void returnCoins() {
        coinReturn.setHasReturn(true);
        coinReturn.getReturnSlot().addAll(coinHopper.getHopper());

        coinHopper.returnCoins();
    }

    public List<Coin> checkCoinReturn() {
        return coinReturn.retrieveCoins();
    }
}
