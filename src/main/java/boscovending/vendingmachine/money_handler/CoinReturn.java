package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;

import java.util.Collections;
import java.util.List;

public class CoinReturn {
    public List<Coin> retrieveCoins() {
        return Collections.singletonList(Coin.SLUG);
    }
}
