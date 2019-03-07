package boscovending.vendingmachine.user_interface;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Integration Tests for the REST-ful API endpoints:")
public class InterfaceIntegrationTests {
    @Resource
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("/api/display")
    public void articlesRestApiTest() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/display", String.class);
        HttpStatus status = response.getStatusCode();
        assertThat("Response status code is not 200.", status, is(HttpStatus.OK));
    }
}