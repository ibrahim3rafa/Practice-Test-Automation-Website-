package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exceptionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addButton = By.id("add_btn");
    private final By inputField = By.xpath("//input[@class='input-field']");
    public exceptionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }

    public boolean inputFieldDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
        return driver.findElement(inputField).isDisplayed();
    }

    public void secondRowInputFieldDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
    }


}
