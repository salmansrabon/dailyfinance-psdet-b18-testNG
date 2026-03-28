package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    By btnAddCost= By.className("add-cost-button");
    By txtItemName=By.id("itemName");
    By txtAmount=By.id("amount");
    By txtRemarks=By.id("remarks");
    By btnSubmit=By.cssSelector("[type=submit]");
    WebDriver driver;
    public UserPage(WebDriver driver){
        this.driver=driver;
    }
    public void addNewCost() throws InterruptedException {
        driver.findElement(btnAddCost).click();
        driver.findElement(txtItemName).sendKeys("Test Item");
        driver.findElement(txtAmount).sendKeys("100");
        driver.findElement(txtRemarks).sendKeys("Added new product");
        driver.findElement(btnSubmit).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}
