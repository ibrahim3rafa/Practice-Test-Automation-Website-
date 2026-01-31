package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class tablePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By selectJavaLanguage = By.xpath("//input[@value='Java']");
    private final By selectPythonLanguage = By.xpath("//input[@value='Python']");
    private final By selectAnyLanguage = By.xpath("//input[@value='Any']");
    public tablePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }


    public void selectLanguage(String language) {
        // Implement logic to select language filter in the table
        // This is a placeholder method; replace it with actual implementation
        switch (language.toLowerCase()) {
            case "java":
                // Code to filter table by Java
                driver.findElement(selectJavaLanguage).click();
                break;
            case "python":
                // Code to filter table by Python
                driver.findElement(selectPythonLanguage).click();
                break;
            default:
                // Code for default case
                driver.findElement(selectAnyLanguage).click();
                break;
        }
    }

    public boolean isLanguageFiltered(String language) {
        // Implement logic to verify if the table is filtered by the selected language
        // This is a placeholder method; replace it with actual implementation
        // For example, check if all visible rows in the table contain the specified language
        List<WebElement> languageCells = driver.findElements(By.xpath("//td[@headers='col_lang']")); // Assuming language is in the third column
        for (WebElement cell : languageCells) {
            if (!cell.getText().equalsIgnoreCase(language)) {
                return false;
            }
        }
        return true; // Placeholder return value
    }
}
