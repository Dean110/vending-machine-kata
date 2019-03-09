package boscovending.vendingmachine.money_handler;

public class MoneyHandlerFactory {
    public static MoneyHandler createMoneyHandler() {
        return new MoneyHandler(new CoinHopper());
    }
}
