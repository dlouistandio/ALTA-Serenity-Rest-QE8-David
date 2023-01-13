package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //POST USER
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
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    //PUT UPDATE USER
    @Given("Put update user with valid json and {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST+"RequestUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }

    //DELETE USER
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }
    //Validate json schmea
    @And("validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
