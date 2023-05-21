package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }
    @When("Send get lists users")
    public void sendGetListsUsers() {
    SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) { SerenityRest.and().body("page",equalTo(page));
    }

    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.postCreateUser(json);}
    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("Response body name was {string} job was {string}")
    public void responseBodyNameWasJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate get create user JSON Schema")
    public void validateGetCreateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.putupdateuser(id, json);
    }
    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Response body for put name was {string} job was {string}")
    public void responseBodyForPutNameWasJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate put update user JSON Schema")
    public void validatePutUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
      reqresAPI.deleteuser(id);
    }
    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
    SerenityRest.then().statusCode(noContent);
    }


    @Given("Get single users with valid parameter {int}") //TUGAS
    public void getSingleUsersWithValidParameter(int id) {
        reqresAPI.SingleUserValidParamPage(id);
    }
    @When("Send get single users")
    public void sendGetSingleUsers() { SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }

    @And("Response body Single page should be {int}")
    public void responseBodySinglePageShouldBe(int id) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id));
    }
    @And("Validate get single user JSON Schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Post create register with valid json")
    public void postCreateRegisterWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterReqBody.json");
        reqresAPI.postCreateRegister(json);
    }
    @When("Send post create register")
    public void sendPostCreateRegister() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_REGISTER);
    }
    @And("Validate create new user JSON Schema")
    public void validateCreateNewUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateRegisterJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Post login with valid json")
    public void postLoginWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterReqBody.json");
        reqresAPI.postLogin(json);
    }
    @When("Send post login successful")
    public void sendPostLoginSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }
    @And("Validate login JSON Schema")
    public void validateLoginJSONSchema() {
        File json = new File(Constants.REQ_BODY_DIR+"PostLoginJSONSchema.json");
        reqresAPI.postLogin(json);

    }
    @Given("Delay respon with valid parameter {int}")
    public void delayResponWithValidParameter(int time) {
        reqresAPI.delayResponsePage(time);
    }


    @When("Send response delay")
    public void sendResponseDelay() { SerenityRest.when().get(ReqresAPI.DELAY_RESPONSE);
    }
    @And("Validate delay page JSON Schema")
    public void validateDelayPageJSONSchema() {
        File json = new File(Constants.REQ_BODY_DIR+"DelayJSONSchema.json");
        reqresAPI.postLogin(json);
    }

    @Given("Patch user with valid json and id {int}")
    public void patchUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.patchUpdateUser(id, json);
    }

    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().get(ReqresAPI.PATCH_UPDATE_USER);
    }
    @And("Validate patch user JSON Schema")
    public void validatePatchUserJSONSchema() {
        File json = new File(Constants.REQ_BODY_DIR+"PatchUserJSONSchema.json");
        reqresAPI.postLogin(json);
    }
    @Given("Get single user with invalid parameter {int}")
    public void getSingleUserWithInvalidParameter(int id) { reqresAPI.getSingleUserNotFound(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int noFound) { SerenityRest.then().statusCode(noFound);
    }



}
