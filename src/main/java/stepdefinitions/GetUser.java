package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class GetUser {
    public  int ResponseCode;
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;


    @Given("I hit the url of get user api endpoint")
    public void I_hit_the_url_of_get_user_api_endpoint(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";


    }
    @When("I pass the url in as request with username")
    public void i_pass_the_url_in_as_request_with_username() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("user/user1");
    }

    @Then("I get the response code as {int}")
    public void i_get_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
    }

    @Then("I verify the UserName of given user {string}")
    public void iVerifyTheUserNameOfGivenUser(String expectedUsername) {
        String body = response.getBody().asString();
        JsonPath js = new JsonPath(body); // Initialize JsonPath with the response body
        String actualUsername = js.getString("username");
        assertEquals(expectedUsername, actualUsername);
    }
}
