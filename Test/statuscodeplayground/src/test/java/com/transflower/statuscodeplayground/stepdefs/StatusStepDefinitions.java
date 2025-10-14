package com.transflower.statuscodeplayground.stepdefs;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatusStepDefinitions {

    @LocalServerPort
    private int port;

    private ResponseEntity<String> response;

    private final RestTemplate restTemplate = new RestTemplate();

    @When("I send GET request to {string}")
    public void iSendGetRequestTo(String path) {
        String url = "http://localhost:" + port + path;
        response = restTemplate.getForEntity(url, String.class);
    }

    @When("I send POST request to {string}")
    public void iSendPostRequestTo(String path) {
        String url = "http://localhost:" + port + path;
        response = restTemplate.postForEntity(url, null, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        assertEquals(expectedStatus, response.getStatusCodeValue());
    }

    @And("the response should contain {string}")
    public void theResponseShouldContain(String expectedText) {
        assertTrue(response.getBody().toLowerCase().contains(expectedText.toLowerCase()));
    }
}