package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresAPI {
    /*Sebagai URL dan PATH API*/
    public static String BASE_URL = "https://reqres.in";

    public static String GET_LIST_USERS = BASE_URL+"/api/users?page={page}"; /*{page} dipanggil pada .pathParam di step*/

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

}
