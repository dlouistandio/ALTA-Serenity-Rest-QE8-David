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

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put update user with invalid json and valid id {int}")
    public void putUpdateUserWithInvalidJsonAndId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST+"InvalidReqUser.json");
        reqresAPI.putUpdateUser(id ,json);
    }

    @Given("Put update user with valid json and invalid id {string}")
    public void putUpdateUserWithValidJsonAndInvalidId(String id) {
        File json = new File(ReqresAPI.JSON_REQUEST+"RequestUser.json");
        reqresAPI.putInvalidUpdateUser(id ,json);
    }

    @Given("Put update user with empty json key and valid id {int}")
    public void putUpdateUserWithEmptyJsonKeyAndValidId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST+"EmptyKeyUser.json");
        reqresAPI.putUpdateUser(id ,json);
    }
}
