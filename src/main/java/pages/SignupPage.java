package pages;

import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    By txtFirstName= By.id("firstName");
    By txtLastName=By.id("lastName");
    By txtEmail=By.id("email");
    By txtPassword=By.id("password");
    By txtPhoneNumber=By.id("phoneNumber");
    By txtAddress=By.id("address");
    By rbGender=By.cssSelector("[type=radio]");
    By chkTerms=By.cssSelector("[type=checkbox]");
    By btnRegister=By.id("register");
    public WebDriver driver;

    public SignupPage(WebDriver driver){
        this.driver=driver;
    }
    public void doSignup(UserModel userModel){
        driver.findElement(txtFirstName).sendKeys(userModel.getFirstname());
        driver.findElement(txtLastName).sendKeys(userModel.getLastname()==null?"": userModel.getLastname());
        driver.findElement(txtEmail).sendKeys(userModel.getEmail());
        driver.findElement(txtPassword).sendKeys(userModel.getPassword());
        driver.findElement(txtPhoneNumber).sendKeys(userModel.getPhonenumber());
        driver.findElement(txtAddress).sendKeys(userModel.getAddress()==null?"": userModel.getAddress());
        driver.findElements(rbGender).get(0).click();
        driver.findElement(chkTerms).click();
        driver.findElement(btnRegister).click();

    }
}
