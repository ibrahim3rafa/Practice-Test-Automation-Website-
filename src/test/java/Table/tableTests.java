package Table;

import Pages.tablePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tableTests extends Base.baseTest {


    private final By tableUrl = By.xpath("//a[.='Test Table']");
    private static tablePage tablepage;

    @BeforeClass
    public void enterTablePage() {
        driver.findElement(tableUrl).click();
        // Navigate to the table test page before running tests
        tablepage = new tablePage(driver, wait);
    }

    @Test
    public void languageFilterTest() {
        // Implement test logic for language filter in the table
        // Add assertions to verify the expected behavior
        tablepage.selectLanguage("Java");
        // Verify that the table is filtered by Java
        //As there are 3 elements with other languages not Java and not visible at UI
        Assert.assertTrue(tablepage.isLanguageFiltered("Java"));
    }

    @Test
    public void levelFilterTest() {
        // Implement test logic for level filter in the table
        // Add assertions to verify the expected behavior
        // Verify that the table is filtered by the selected levels
        tablepage.selectLevel("Beginner");
        Assert.assertTrue(tablepage.isLevelFiltered("Beginner"));
    }

    @Test
    public void minEnrollmentFilterTest() {
        // Implement test logic for minimum enrollment filter in the table
        // Add assertions to verify the expected behavior
        String[] enrollments = {"Any", "5,000+", "10,000+", "50,000+"};
        tablepage.setMinEnrollment(enrollments[2]); // Set minimum enrollment to "10,000+"
        // Verify that the table is filtered by minimum enrollment
        Assert.assertTrue(tablepage.isMinEnrollmentFiltered(enrollments[2]));
    }

}
