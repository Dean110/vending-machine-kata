package boscovending.vendingmachine.money_handler;

import boscovending.vendingmachine.utility.Coin;
import lombok.Getter;

import java.util.ArrayList;

public class CoinHopper {

    @Getter
    private ArrayList<Coin> hopper;

    public CoinHopper() {
        hopper = new ArrayList<>();
    }


    public void depositMoney(Coin coin) {
        hopper.add(coin);
    }


}
