package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class tablePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By selectJavaLanguage = By.xpath("//input[@value='Java']");
    private final By selectPythonLanguage = By.xpath("//input[@value='Python']");
    private final By selectAnyLanguage = By.xpath("//input[@value='Any']");
    private final By levelFilterBeginner = By.cssSelector("input[name='level'][value='Beginner']");
    private final By levelFilterIntermediate = By.cssSelector("input[name='level'][value='Intermediate']");
    private final By levelFilterAdvanced = By.cssSelector("input[name='level'][value='Advanced']");
    private final By enrollmentDropdown = By.id("enrollDropdown");
    private final By noResultsMessage = By.xpath("//div[@id='noData']");

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
            if (cell.isDisplayed()) {
                String cellText = cell.getText();
                if (!cellText.equalsIgnoreCase(language)) {
                    return false;
                }
            }
        }
        return true; // Placeholder return value
    }

    public void selectLevel(String level) {

        // Code to filter table by Beginner level
        if (!driver.findElement(levelFilterBeginner).isSelected()) {
            driver.findElement(levelFilterBeginner).click();
        }

        // Code to filter table by Intermediate level
        if (driver.findElement(levelFilterIntermediate).isSelected()) {
            driver.findElement(levelFilterIntermediate).click();
        }

        if (driver.findElement(levelFilterAdvanced).isSelected()) {
            driver.findElement(levelFilterAdvanced).click();
        }

    }
    // Implement logic to select level filter in the table
    // This is a placeholder method; replace it with actual implementation

    public boolean isLevelFiltered(String level) {
        // Implement logic to verify if the table is filtered by the selected level
        // This is a placeholder method; replace it with actual implementation
        // For example, check if all visible rows in the table contain the specified level
        List<WebElement> levelCells = driver.findElements(By.xpath("//fieldset[2]"));
        // Assuming level is in the fourth column
        for (WebElement card : levelCells) {
            if (card.isDisplayed()) {
                String cellText = card.getText();
                if (!cellText.contains(level)) {
                    return false;
                }
            }
        } // Placeholder return value
        return true;
    }

    public void setMinEnrollment(String enrollment) {
        // Implement logic to set minimum enrollment filter in the table
        // This is a placeholder method; replace it with actual implementation
        WebElement dropdown = driver.findElement(enrollmentDropdown);
        dropdown.click();
        WebElement option = dropdown.findElement(By.xpath("//li[text()='" + enrollment + "']"));
        option.click();
    }

    public boolean isMinEnrollmentFiltered(String enrollment) {
        // Implement logic to verify if the table is filtered by the selected minimum enrollment
        // This is a placeholder method; replace it with actual implementation
        // For example, check if all visible rows in the table have enrollment greater than or equal to the selected value
        String minEnrollmentElement = driver.findElement(By.cssSelector(".dropdown-label")).getText();
        if (minEnrollmentElement.contains(enrollment)) {
            return true;
        }
        return false; // Placeholder return value
    }

    public boolean isNoResultsDisplayed() {
        // Implement logic to verify if no results message is displayed in the table
        // This is a placeholder method; replace it with actual implementation
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        return driver.findElement(noResultsMessage).isDisplayed();// Placeholder return value
    }
}

