package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

public class ReqresAPI {
    /*Sebagai URL dan PATH API*/
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request/";
    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema/";

    public static String GET_LIST_USERS = BASE_URL+"/api/users?page={page}"; /*{page} dipanggil pada .pathParam di step*/
    public static String GET_SINGLE_USERS = BASE_URL+ "/api/users/{id}";
    public static String POST_CREATE_USERS = BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = BASE_URL+"/api/users/{id}";
    public static String EMPTY_DELETE_USER = BASE_URL+"/api/users/";

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);

    }


    @Step("Get list users")
    public void invalidGetSingleUserId(String id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

    @Step("Get list users")
    public void invalidGetListUsersId(String page){
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);
    }

    @Step("Post create users")
    public void postCreateUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update users")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update users")
    public void putInvalidUpdateUser(String id, File json){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete users")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id);
    }

    @Step("Delete users")
    public void invalidDeleteUser(String id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID,id);
    }

    @Step("Delete users")
    public void emptyParamDeleteUser(){
        SerenityRest.given()
                .basePath(EMPTY_DELETE_USER);
    }
}
