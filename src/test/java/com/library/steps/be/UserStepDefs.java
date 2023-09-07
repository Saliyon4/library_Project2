package com.library.steps.be;

import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class UserStepDefs {
    RequestSpecification requestSpecification;
   Response response;
   String token= LibraryAPI_Util.getToken();
  //String token= LoginStepDefs.gloabalTokenForEachClass;
    @Given("Accept header is {string}")
    public void accept_header_is(String acceptType) {
    requestSpecification = RestAssured.given().accept(acceptType);
    }
    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endPont) {
      response=requestSpecification

              .header("x-library-token",token)
              .get(endPont);

    }
    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);

    }
    @Then("Response Content type is {string}")
    public void response_content_type_is(String expectedContentType) {
        String actualContentType = response.contentType();
        Assert.assertEquals(expectedContentType,actualContentType);
    }
    @Then("{string} field should not be null")
    public void field_should_not_be_null(String key) {
   response.then().body(key, everyItem(notNullValue()));
    }

}
