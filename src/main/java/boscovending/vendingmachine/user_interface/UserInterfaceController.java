package boscovending.vendingmachine.user_interface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInterfaceController {

    private VendingMachineDisplay display;

    public UserInterfaceController() {
        display = VendingMachineDisplayFactory.createDisplay();
    }

    @GetMapping("/api/display")
    public String checkDisplayMessage() {
        return display.getMessage();
    }
}
