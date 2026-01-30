package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exceptionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addButton = By.id("add_btn");
    private final By inputField = By.xpath("(//input[@type='text'])[2]");
    private final By saveButton = By.xpath("(//button[text()='Save'])[2]");

    public exceptionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }

    public boolean inputFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
        return driver.findElement(inputField).isDisplayed();
    }

    public void secondRowInputFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
    }

    public void enterTextAtSecondRow(String text) {
        // This method can be implemented to enter text into the second row input field
        driver.findElement(inputField).sendKeys(text);
        driver.findElement(saveButton).click();
    }




}
