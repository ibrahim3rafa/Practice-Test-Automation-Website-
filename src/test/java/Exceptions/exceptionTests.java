package Exceptions;

import Pages.exceptionPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public void elementNotInteractableException() {
        exceptionpage.clickAddButton();
        // Implement test logic for ElementNotVisibleException
        exceptionpage.secondRowInputFieldDisplayed();
        // Add assertions to verify the expected behavior
        exceptionpage.enterTextAtSecondRowAndSave(inputText);
        // This is a placeholder assertion; replace it with actual verification logic
        Assert.assertEquals(exceptionpage.getConfirmationMessage(), "Row 2 was saved");
    }

    @Test
    public void invalidElementStateException() {
        exceptionpage.clickEditButton();
        exceptionpage.enterTextAtFirstRowAndSave(inputText);
        //Verify that text changed
        Assert.assertEquals(exceptionpage.getConfirmationMessage(), "Row 1 was saved");
    }

    @Test
    public void staleElementReferenceException() {
        WebElement instruction = exceptionpage.instructionsAreDisplayed();
        exceptionpage.clickAddButton();
        try {
            boolean isDisplayed = instruction.isDisplayed();
            Assert.fail("Expected StaleElementReferenceException was not thrown. Displayed: " + isDisplayed);
        } catch (StaleElementReferenceException e) {
            // If we hit this block, the test passes because the element is indeed stale
            Assert.assertTrue(true, "Successfully caught expected StaleElementReferenceException");
        }
    }

    @Test
    public void timeoutException() {
        // Implement test logic for TimeoutException
        // This is a placeholder implementation; replace it with actual verification logic
       exceptionpage.clickAddButton();
         Assert.assertTrue(exceptionpage.inputFieldDisplayed());
    }
}



