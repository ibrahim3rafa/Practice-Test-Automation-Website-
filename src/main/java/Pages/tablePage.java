package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final By resetButton = By.id("resetFilters");

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
                if (!cellText.contains(language)) {
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

        // ✅ Handle "Any"
        if (enrollment == null || enrollment.equalsIgnoreCase("Any")) {
            return true; // No filter applied
        }

        int minEnrollment;
        try {
            minEnrollment = Integer.parseInt(
                    enrollment.replace(",", "").replace("+", "").trim()
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Invalid enrollment filter value: " + enrollment, e
            );
        }

        List<WebElement> enrollmentCells = driver.findElements(
                By.xpath("//td[@headers='col_enroll']")
        );

        for (WebElement cell : enrollmentCells) {

            if (!cell.isDisplayed()) {
                continue; // ignore hidden rows
            }

            int value = Integer.parseInt(cell.getText().trim());

            if (value < minEnrollment) {
                return false;
            }
        }

        return true;
    }


    public boolean isNoResultsDisplayed() {
        // Implement logic to verify if no results message is displayed in the table
        // This is a placeholder method; replace it with actual implementation
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        return driver.findElement(noResultsMessage).isDisplayed();// Placeholder return value
    }

    public void clickResetButton() {
        // Implement logic to click the reset button to clear all filters
        // This is a placeholder method; replace it with actual implementation
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetButton));
        driver.findElement(resetButton).click();
    }

    public boolean resetButtonIsVisible() {
        // Implement logic to verify if the reset button is visible after applying filters
        // This is a placeholder method; replace it with actual implementation
        return driver.findElement(resetButton).isDisplayed(); // Placeholder return value
    }
}






/*
*package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Integer.parseInt;

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
    private final By resetButton = By.id("resetFilters");


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
                if (!cellText.contains(language)) {
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

        // 1️⃣ Convert "5,000+" → 5000
        int minEnrollment = Integer.parseInt(
                enrollment.replace(",", "").replace("+", "").trim()
        );

        // 2️⃣ Get only visible enrollment cells
        List<WebElement> enrollmentCells = driver.findElements(
                By.xpath("//td[@headers='col_enroll' and not(contains(@style,'display: none'))]")
        );

        // 3️⃣ Validate each visible enrollment value
        for (WebElement cell : enrollmentCells) {

            if (!cell.isDisplayed()) {
                continue; // safety check
            }

            int value = Integer.parseInt(cell.getText().trim());

            if (value < minEnrollment) {
                return false;
            }
        }

        return true; // ✅ All values match the filter
    }

        return true; // Placeholder return value
    }

    public boolean isNoResultsDisplayed() {
        // Implement logic to verify if no results message is displayed in the table
        // This is a placeholder method; replace it with actual implementation
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        return driver.findElement(noResultsMessage).isDisplayed();// Placeholder return value
    }

    public void clickResetButton() {
        // Implement logic to click the reset button to clear all filters
        // This is a placeholder method; replace it with actual implementation
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetButton));
        driver.findElement(resetButton).click();
    }

    public boolean resetButtonIsVisible() {
        // Implement logic to verify if the reset button is visible after applying filters
        // This is a placeholder method; replace it with actual implementation
        return driver.findElement(resetButton).isDisplayed(); // Placeholder return value
    }
}

 */
