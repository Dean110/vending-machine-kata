package boscovending.vendingmachine.user_interface;

public class DisplayController {

    private VendingMachineDisplay display;

    public DisplayController() {
        display = VendingMachineDisplayFactory.createDisplay();
    }

    public String checkDisplayMessage() {
        return display.getMessage();
    }
}
