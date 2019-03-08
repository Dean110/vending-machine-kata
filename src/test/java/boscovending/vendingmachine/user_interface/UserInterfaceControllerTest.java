package boscovending.vendingmachine.user_interface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("UserInterfaceController unit tests:")
class UserInterfaceControllerTest {

    private UserInterfaceController underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserInterfaceController();
    }

    @Test
    @DisplayName("A vending machine with no coins inserted and available change should display \"INSERT COIN\"")
    void checkDisplayMessage_noCoinsInserted_displayInsertCoin() {
        String displayMessage = underTest.checkDisplayMessage();
        assertThat(displayMessage).isEqualTo("INSERT COIN");
    }
}