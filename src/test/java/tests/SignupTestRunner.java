package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.JSONManager;
import utils.RandomNumber;

import java.io.IOException;

public class SignupTestRunner extends BaseTest {
    @Test
    public void signup() throws IOException, ParseException {
        Faker faker=new Faker();
        SignupPage signupPage=new SignupPage(driver);
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email="salmansrabon+"+ RandomNumber.generateRandomNumber(1000,9999) +"@gmail.com";
        String password="1234";
        String phoneNumber="0150"+RandomNumber.generateRandomNumber(1000000,9999999);
        String address="Dhaka";

        driver.findElement(By.partialLinkText("Register")).click();
        signupPage.doSignup(firstName,lastName,email,password,phoneNumber,address);
        JSONManager.saveJSONData(firstName,lastName,email,password,phoneNumber,address);
    }
}
