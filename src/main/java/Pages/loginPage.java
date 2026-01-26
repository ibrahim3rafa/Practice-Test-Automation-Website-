package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By loggedSuccessfullyHeader = By.xpath("//h1[text()='Logged In Successfully']");
    private final By logoutButton = By.xpath("//a[text()='Log out']");
    private final By errorMessage = By.id("error");
    public loginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Methods
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }

    public String getCurrentUrlAfterLogin() {
        //WebElements
        String expectedUrlPart = "practicetestautomation.com/logged-in-successfully/";
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        return driver.getCurrentUrl();
    }

    public boolean isLoggedInSuccessfullyHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedSuccessfullyHeader));
        return driver.findElement(loggedSuccessfullyHeader).isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
    }

    //error message of username appears
    public String isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }



}
