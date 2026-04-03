package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import models.UserModel;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SignupPage;
import services.GmailService;
import utils.JSONManager;
import utils.RandomNumber;

import java.io.IOException;

public class SignupTestRunner extends BaseTest {
    @Test(priority = 1,description = "Signup user by all fields")
    public void signup() throws IOException, ParseException, InterruptedException {
        Faker faker=new Faker();
        SignupPage signupPage=new SignupPage(driver);
        UserModel userModel=new UserModel();
        userModel.setFirstname(faker.name().firstName());
        userModel.setLastname(faker.name().lastName());
        userModel.setEmail("salmansrabon+"+ RandomNumber.generateRandomNumber(1000,9999) +"@gmail.com");
        userModel.setPassword("1234");
        userModel.setPhonenumber("0150"+RandomNumber.generateRandomNumber(1000000,9999999));
        userModel.setAddress("Dhaka");

        driver.findElement(By.partialLinkText("Register")).click();
        signupPage.doSignup(userModel);
        JSONManager.saveJSONData(userModel);
        Thread.sleep(5000);
        String emailData= GmailService.readLatestGmail();
        System.out.println(emailData);
        Assert.assertTrue(emailData.contains("Welcome to our platform"));
    }
    @Test(priority = 2, description = "Signup with mandatory fields only")
    public void signup_mandatory() throws IOException, ParseException {
        Faker faker=new Faker();
        SignupPage signupPage=new SignupPage(driver);
        UserModel userModel=new UserModel();
        userModel.setFirstname(faker.name().firstName());
        userModel.setEmail("salmansrabon+"+ RandomNumber.generateRandomNumber(1000,9999) +"@gmail.com");
        userModel.setPassword("1234");
        userModel.setPhonenumber("0150"+RandomNumber.generateRandomNumber(1000000,9999999));

        driver.findElement(By.partialLinkText("Register")).click();
        signupPage.doSignup(userModel);
        JSONManager.saveJSONData(userModel);
    }
}
