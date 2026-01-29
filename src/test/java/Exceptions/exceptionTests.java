package Exceptions;

import Pages.exceptionPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class exceptionTests extends Base.baseTest {

    private final By exceptionTestsLink = By.xpath("//a[.='Test Exceptions']");
    private final By exceptionTestPageHeader = By.xpath("//h2[contains(text(),'Test Exceptions')]");
    private String inputText = "IbrahimArafa";
    private exceptionPage exceptionpage;

    @BeforeClass
    public void enterExceptionPage() {
        driver.findElement(exceptionTestsLink).click();
        // Navigate to the exception test page before running tests
        //Assert that we are on the correct page
        Assert.assertEquals(driver.findElement(exceptionTestPageHeader).getText(), "Test Exceptions");
        exceptionpage = new exceptionPage(driver, wait);

    }

    @Test
    public void noSuchElementExceptionTest() {
        // Implement test logic for NoSuchElementException
        exceptionpage.clickAddButton();
        // Add assertions to verify the expected behavior
        // For example, check if a new element is added to the DOM
        // This is a placeholder assertion; replace it with actual verification logic
        Assert.assertTrue(exceptionpage.inputFieldDisplayed());
    }

    @Test
    public void elementNotVisibleExceptionTest() {
        exceptionpage.clickAddButton();
        // Implement test logic for ElementNotVisibleException
        exceptionpage.secondRowInputFieldDisplayed();
        // Add assertions to verify the expected behavior

    }
}



