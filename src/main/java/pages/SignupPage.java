package pages;

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
    public void doSignup(String firstName, String lastName, String email, String password, String phoneNumber, String address){
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElements(rbGender).get(0).click();
        driver.findElement(chkTerms).click();
        driver.findElement(btnRegister).click();

    }
}
