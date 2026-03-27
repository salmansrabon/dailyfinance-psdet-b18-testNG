package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By txtEmail= By.id("email");
    By txtPassword=By.id("password");
    By btnLogin=By.cssSelector("[type=submit]");
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void userLogin(String email, String password){
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}
