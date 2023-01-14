package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef {
    //GET LIST USERS
    @Steps
    ReqresAPI reqresAPI = new ReqresAPI();
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should be {int}")
    public void responseBodyShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list user with id {int}")
    public void getListUserWithId(int id) {
        reqresAPI.getListUsers(id);
    }


    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Given("Get list user with invalid page {string}")
    public void getListUserWithInvalidId(String id) {
        reqresAPI.invalidGetListUsersId(id);
    }
}
