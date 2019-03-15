package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;

import java.math.BigDecimal;
import java.util.List;

public class MoneyHandler {
    private CoinHopper coinHopper;
    private CoinReturn coinReturn;

    public MoneyHandler(CoinHopper coinHopper, CoinReturn coinReturn) {
        this.coinHopper = coinHopper;
        this.coinReturn = coinReturn;
    }


    public BigDecimal getHopperBalance() {
        List<Coin> hopperContents = coinHopper.getHopper();
        return coinHopper.getHopper()
                         .stream()
                         .map(Coin::getValue)
                         .reduce(new BigDecimal("0.00"), BigDecimal::add);
    }

    public void insertCoin(Coin coin) {
        coinHopper.depositMoney(coin);
    }

    public void returnCoins() {
        coinReturn.setHasReturn(true);
        coinReturn.getReturnSlot().addAll(coinHopper.getHopper());
        coinHopper.getHopper().clear();
    }

    public List<Coin> checkCoinReturn() {
        return coinReturn.retrieveCoins();
    }
}
