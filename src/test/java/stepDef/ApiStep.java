package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.setUpUrl(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitGetListUser();
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationBodyGetListUsers();
    }

    @Then("Validation status code is equal {int}")
    public void validationStatusCodeIsEqual(int status_code) {
        apiPage.validationStatusCode(status_code);
    }

    @Then("Validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationJSONSChema(filename);
    }

    @Then("validation response body get profile users")
    public void validationResponseBodyGetProfileUsers() {
        apiPage.validationBodyGetProfileUsers();
    }

    @When("hit api get profile user by id {string}")
    public void hitApiGetProfileUserById(String global_user_id) {
        apiPage.hitGetProfileUser(global_user_id);
    }

    @Then("validation response body with message {string}")
    public void validationResponseBodyWithMessage(String error) {
        apiPage.validationErorrMassage(error);
    }

    @When("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationBodyPostCreateNewUsers();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPage.hitUpdateUser();

    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationBodyPostCreateNewUsers();
    }

    @When("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitDeleteUser();
    }

    @When("hit delete user by id {string}")
    public void hitDeleteUserById(String user_id) {
        apiPage.hitDeleteUserById(user_id);
    }

    @When("hit api get list tags")
    public void hitApiGetListTags() {
        apiPage.hitGetListUser();
    }

    @Then("validation response body get list tags")
    public void validationResponseBodyGetListTags() {
        apiPage.validateListTxag();
    }
}
