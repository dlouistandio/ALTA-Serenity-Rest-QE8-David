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

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Validate json schmea
    @And("validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA+"ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


}
