package boscovending.vendingmachine.money_handler;

import java.math.BigDecimal;

public class MoneyHandler {
    CoinHopper coinHopper;

    public MoneyHandler(CoinHopper coinHopper){
        this.coinHopper = coinHopper;
    }


    public BigDecimal getDepositBalance() {
        return coinHopper.getBalance();
    }
}
