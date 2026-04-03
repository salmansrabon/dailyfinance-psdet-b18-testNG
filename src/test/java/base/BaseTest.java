package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeTest(groups = "smoke")
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(ConfigReader.getInstance().get("baseUrl"));
    }
    @AfterTest(groups = "smoke")
    public void tearDown(){
        driver.quit();
    }
}
