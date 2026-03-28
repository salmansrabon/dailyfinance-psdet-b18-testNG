package tests;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends BaseTest {
    @Test(priority = 1, description = "Check if user can login with wrong creds")
    public void userLoginWithWrongCreds(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.userLogin("admin@test.com","wrongpass");
        String messageActual= driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(messageActual.contains("Invalid"));
        clearData();
    }
    @Test(priority = 2, description = "Check if user can login with correct creds")
    public void userLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.userLogin("admin@test.com","admin123");
    }
    public void clearData(){
        LoginPage loginPage=new LoginPage(driver);
        driver.findElement(loginPage.txtEmail).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        driver.findElement(loginPage.txtPassword).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
    }
}
