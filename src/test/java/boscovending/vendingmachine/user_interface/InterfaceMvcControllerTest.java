package boscovending.vendingmachine.user_interface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserInterfaceController.class)
@DisplayName("Spring WebMvcTest for ArticlesController:")
public class InterfaceMvcControllerTest {
    @Resource
    MockMvc mvc;

    @Test
    @DisplayName("get /api/display")
    public void shouldRetrieveArticles() throws Exception {
        mvc.perform(get("/api/display")).andExpect(status().isOk());
    }
}
