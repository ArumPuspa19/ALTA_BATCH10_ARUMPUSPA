package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static  String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER= Constants.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER= Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USERS = Constants.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_REGISTER = Constants.BASE_URL+"/api/register";
    public static String POST_LOGIN = Constants.BASE_URL+"/api/login";
    public static String GET_SINGLE_USER_NOT_FOUND = Constants.BASE_URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELAY_RESPONSE = Constants.BASE_URL+"/api/users?delay={time}";
    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("PUT update user")
    public void putupdateuser(int id, File json){
        SerenityRest.given().pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete User")
    public void deleteuser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get Single Users with valid parameter page")
    public void SingleUserValidParamPage(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post create new register user")
    public void postCreateRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Post login successful")
    public void postLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Get Single User with invalid parameter page")
    public void getSingleUserNotFound(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){ SerenityRest.given().pathParam("id",id)
            .contentType(ContentType.JSON)
            .body(json);}
    @Step("Delay response page")
    public void delayResponsePage(int time){ SerenityRest.given().pathParam("time",time);}
}
