package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    /*Sebagai URL dan PATH API*/
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request/";

    public static String GET_LIST_USERS = BASE_URL+"/api/users?page={page}"; /*{page} dipanggil pada .pathParam di step*/
    public static String POST_CREATE_USERS = BASE_URL+"/api/users";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create users")
    public void postCreateUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
