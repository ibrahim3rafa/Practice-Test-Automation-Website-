package Pages;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exceptionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    exceptionPage exceptionPage;


    public exceptionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    @BeforeClass
    public void enterExceptionPage() {
        driver.findElement(exceptionTestsLink).click();
        // Navigate to the exception test page before running tests
        //Assert that we are on the correct page
        Assert.assertEquals(driver.findElement(ExceptionTestPageHeader).getText(), "Exception Testing");
        exceptionPage = new exceptionPage(driver, wait);
    }

}
