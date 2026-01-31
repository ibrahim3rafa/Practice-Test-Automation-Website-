package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exceptionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addButton = By.id("add_btn");
    private final By secondRowInputField = By.xpath("(//input[@type='text'])[2]");
    private final By secondRowSaveButton = By.xpath("(//button[text()='Save'])[2]");
    private final By confirmationMessage = By.xpath("//div[@id='confirmation']");
    private final By editButton = By.xpath("(//button[@name='Edit'])[1]");
    private final By firstRowInputField = By.xpath("(//input[@type='text'])[1]");
    private final By firstRowSaveButton = By.xpath("(//button[text()='Save'])[1]");
    private final By instructions = By.id("instructions");


    public exceptionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }

    public boolean inputFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondRowInputField));
        return driver.findElement(secondRowInputField).isDisplayed();
    }

    public void secondRowInputFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondRowInputField));
    }

    public void enterTextAtSecondRowAndSave(String text) {
        // This method can be implemented to enter text into the second row input field
        driver.findElement(secondRowInputField).sendKeys(text);
        driver.findElement(secondRowSaveButton).click();
    }

    public String getConfirmationMessage() {
        // This method can be implemented to get confirmation message after saving
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
         return driver.findElement(confirmationMessage).getText();
    }

    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
        driver.findElement(editButton).click();
    }

    public void enterTextAtFirstRowAndSave(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowInputField));
        driver.findElement(firstRowInputField).clear();
        driver.findElement(firstRowInputField).sendKeys(text);
        driver.findElement(firstRowSaveButton).click();
    }

    public WebElement instructionsAreDisplayed(){
        return driver.findElement(instructions);
    }
}
