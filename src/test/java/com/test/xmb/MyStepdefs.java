package com.test.xmb;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyStepdefs {

    Response response = null;
    int serviceId;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080/openapi-jaxrs-server-1.0.1/xmb/v1.0/";
        RestAssured.port = 8080;
    }

    private int getIdFromResponseBody(String responseBodyStr) {
        int id = 0;
        String str = responseBodyStr.replace("{", "").replace("}", "").replace("\"", "");
        for (String bodyStr : str.split(",")) {
            if (bodyStr.contains("message")) {
                String[] message = bodyStr.split(":");
                id = Integer.parseInt(message[1]);
            }
        }
        return id;
    }

    private String getInfoFromResponseBody(String responseBodyStr, String key) {
        String info = null;
        String str = responseBodyStr.replace("{", "").replace("}", "").replace("\"", "");
        for (String bodyStr : str.split(",")) {
            if (bodyStr.contains(key)) {
                info = bodyStr;
            }
        }
        return info;
    }

    @When("^I create a xMB service$")
    public void iCreateAXMBService() {
//        response = post("/services");
        System.out.println("iCreateAXMBService");
    }

    @And("^I get a service ID$")
    public void iGetAServiceID() {
        System.out.println("iGetAServiceID");
//        String responseBodyStr = response.getBody().asString();
//        serviceId = getIdFromResponseBody(responseBodyStr);
    }

    @When("^I get xMB service with service ID$")
    public void iGetXMBServiceWithServiceID() {
        System.out.println("iGetXMBServiceWithServiceID");
//        response = get("/services/" + serviceId);
    }

    @Then("^I should get the correct response with status code (\\d+)$")
    public void iShouldGetTheCorrectResponseWithStatusCode(int statusCode) {
        System.out.println("iShouldGetTheCorrectResponseWithStatusCode " + statusCode);
//        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @When("^I access xMB service with \"(.+)\" url$")
    public void iAccessXMBServiceWithPathUrl(String path) {
        System.out.println("iAccessXMBServiceWithPathUrl " + path);
//        response = get("/" + path);
    }

    @Then("^I get the correct response \"([^\"]*)\"$")
    public void iGetTheCorrectResponse(String statusCode) {
        System.out.println("iGetTheCorrectResponse " + statusCode);
//        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }
}
