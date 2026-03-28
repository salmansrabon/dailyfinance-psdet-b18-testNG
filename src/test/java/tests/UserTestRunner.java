package tests;

import base.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;
import utils.JSONManager;

import java.io.IOException;

public class UserTestRunner extends BaseTest {
    @BeforeTest
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
//        JSONObject userObj= JSONManager.getLastJSONObject();
//        String email=userObj.get("email").toString();
//        String password=userObj.get("password").toString();

        JSONArray jsonArray= JSONManager.getJSONArray();
        JSONObject userObj= (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email=userObj.get("email").toString();
        String password=userObj.get("password").toString();
        loginPage.userLogin(email,password);
    }
    @Test(priority = 1, description = "User can add new cost")
    public void addNewCost() throws IOException, ParseException, InterruptedException {
        UserPage userPage=new UserPage(driver);
        userPage.addNewCost();
    }
}
