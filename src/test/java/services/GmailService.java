package services;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class GmailService {
    public static String getMessageIdFromGmailList() {
        RestAssured.baseURI = "https://gmail.googleapis.com";
        Response res = given().contentType("application/json")
                .header("Authorization", "Bearer " + ConfigReader.getInstance().get("token"))
                .when().get("/gmail/v1/users/me/messages");

        JsonPath jsonObj = res.jsonPath();
        return jsonObj.get("messages[0].id");
    }
    public static String readLatestGmail(){
        String messageId= getMessageIdFromGmailList();
        RestAssured.baseURI = "https://gmail.googleapis.com";
        Response res = given().contentType("application/json")
                .header("Authorization", "Bearer " + ConfigReader.getInstance().get("token"))
                .when().get("/gmail/v1/users/me/messages/"+messageId);

        JsonPath jsonObj = res.jsonPath();
        return jsonObj.get("snippet");
    }
}
