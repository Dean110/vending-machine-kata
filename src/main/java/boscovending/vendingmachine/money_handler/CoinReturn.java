package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinReturn {
    @Setter
    boolean hasReturn = false;
    @Getter
    ArrayList<Coin> returnSlot = new ArrayList<>();

    public List<Coin> retrieveCoins() {
        if (hasReturn) return returnSlot;

        return Collections.singletonList(Coin.SLUG);
    }
}
