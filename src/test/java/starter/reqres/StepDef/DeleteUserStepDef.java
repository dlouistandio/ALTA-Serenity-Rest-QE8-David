package starter.reqres.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @When("Send request delete user with empty id")
    public void sendRequestEmptyDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.EMPTY_DELETE_USER);
    }


    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.invalidDeleteUser(id);
    }

    @Given("Delete user with unregistered {int}")
    public void deleteUserWithUnregisteredId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user without parameter id")
    public void deleteUserWithoutParameter() {
        reqresAPI.emptyParamDeleteUser();
    }
}
