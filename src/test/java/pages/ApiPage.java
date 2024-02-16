package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    Response res;
    String setUrl, global_user_id = null;
    public void hitGetListUser() {
        res = getListUsers(setUrl);
    }

    public void hitGetProfileUser(String global_user_id){
        res = getListUsers(setUrl+global_user_id);
    }

    public void setUpUrl(String url) {
        switch (url) {
            case"USER_DUMMY":
                setUrl= Endpoint.USER_DUMMY;
                break;
            case "GET_PROFILE_USER":
                setUrl = Endpoint.GET_PROFILE_USER;
                break;
            default:
                System.out.println("Masukan Url yang benar");
        }
    }


    public void validationStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationBodyGetListUsers(){
        String id = res.jsonPath().getString("data[0].id");
        String title = res.jsonPath().getString("data[0].title");
        String fname = res.jsonPath().getString("data[0].firstName");
        String lname = res.jsonPath().getString("data[0].lastName");
        String picture = res.jsonPath().getString("data[0].picture");

        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(fname).isNotNull();
        assertThat(lname).isNotNull();
        assertThat(picture).isNotNull();
    }

    public void validationBodyGetProfileUsers() {
        String id = res.jsonPath().getString("id");
        String title = res.jsonPath().getString("title");
        String fname = res.jsonPath().getString("firstName");
        String lname = res.jsonPath().getString("lastName");
        String picture = res.jsonPath().getString("picture");

        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(fname).isNotNull();
        assertThat(lname).isNotNull();
        assertThat(picture).isNotNull();
    }

    public void validationErorrMassage(String error){

        String error_massage = res.jsonPath().getString("error");

        assertThat(error_massage).isEqualTo("RESOURCE_NOT_FOUND");

    }

    public void validationJSONSChema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPostCreateUser() {
        res = postCreateUser(setUrl);
        System.out.println(res.getBody().asString());
    }


    public void validationBodyPostCreateNewUsers() {
        JsonPath jsonPathValidator = res.jsonPath();
        String id = jsonPathValidator.get("id");
        String fname = jsonPathValidator.get("firstName");
        String lname = jsonPathValidator.get("lastName");
        String email = jsonPathValidator.get("email");

        assertThat(id).isNotNull();
        assertThat(fname).isNotNull();
        assertThat(lname).isNotNull();
        assertThat(email).isNotNull();

        global_user_id = id;
    }

    public void hitUpdateUser() {
        res = updateUser(setUrl, global_user_id);
    }


    public void hitDeleteUser() {
        res = deleteUser(setUrl, global_user_id);
    }

    public void hitDeleteUserById(String userId) {
        res = deleteUser(setUrl,userId);
    }
}
