package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class baseTest {

    public  WebDriver driver;
    public WebDriverWait wait;
    private final By practiceText = By.xpath("//h1[normalize-space()='Practice']");

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
        Assert.assertEquals(driver.findElement(practiceText).getText(), "Practice");
    }



    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
