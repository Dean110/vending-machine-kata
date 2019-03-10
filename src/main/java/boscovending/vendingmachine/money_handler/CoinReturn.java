package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

public class CoinReturn {
    @Setter
    boolean hasReturn = false;

    public List<Coin> retrieveCoins() {
        if (hasReturn) return Collections.singletonList(Coin.DIME);

        return Collections.singletonList(Coin.SLUG);
    }
}
