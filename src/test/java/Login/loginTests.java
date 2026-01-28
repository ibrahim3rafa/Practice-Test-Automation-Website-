package Login;

import Pages.loginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTests extends Base.baseTest {

    private final By loginTestsLink = By.xpath("//a[contains(text(),'Test Login Page')]");
    private final By TestLoginPageHeader = By.xpath("//h2[text()='Test login']");
    loginPage loginpage;

    @BeforeClass
    public void enterLoginPage() {
        driver.findElement(loginTestsLink).click();
        // Navigate to the login test page before running tests
        //Assert that we are on the correct page
        Assert.assertEquals(driver.findElement(TestLoginPageHeader).getText(), "Test login");
        loginpage = new loginPage(driver, wait);
    }

    @Test
    public void validLoginTest() {
        loginpage.enterUsername("student");
        loginpage.enterPassword("Password123");
        loginpage.clickSubmit();
        // Add assertions to verify successful login
        Assert.assertTrue(loginpage.getCurrentUrlAfterLogin().contains("practicetestautomation.com/logged-in-successfully/"));
        Assert.assertTrue(loginpage.isLoggedInSuccessfullyHeaderDisplayed());
        Assert.assertTrue(loginpage.isLogoutButtonDisplayed());
    }

    //Test case 2: Negative username test
    @Test
    public void negativeUsernameTest() {
        loginpage.enterUsername("incorrectUser");
        loginpage.enterPassword("Password123");
        loginpage.clickSubmit();
        // Add assertions to verify unsuccessful login
        //Assertion error message appears
        Assert.assertEquals(loginpage.isErrorMessageDisplayed(), "Your username is invalid!");
    }

    @Test
    public void negativePasswordTest() {
        loginpage.enterUsername("student");
        loginpage.enterPassword("incorrectPass");
        loginpage.clickSubmit();
        // Add assertions to verify unsuccessful login
        //Assertion error message appears
        Assert.assertEquals(loginpage.isErrorMessageDisplayed(), "Your password is invalid!");
    }
}

