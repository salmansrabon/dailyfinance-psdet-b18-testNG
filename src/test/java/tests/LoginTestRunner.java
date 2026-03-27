package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends BaseTest {
    @Test
    public void userLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.userLogin("admin@test.com","admin123");
    }
}
