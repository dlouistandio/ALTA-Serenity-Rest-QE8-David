package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST+"RequestUser.json");
        reqresAPI.postCreateUsers(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USERS);
    }

    @And("Response body name should be {string} and job should be {string}")
    public void responseBodyNameShouldBeAndJobShouldBe(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("validate json schema new user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST+"InvalidReqUser.json");
        reqresAPI.postCreateUsers(json);
    }

    @Given("Post create user with empty json key")
    public void postCreateUserWithEmptyJsonKey() {
        File json = new File(ReqresAPI.JSON_REQUEST+"EmptyKeyUser.json");
        reqresAPI.postCreateUsers(json);
    }
}
