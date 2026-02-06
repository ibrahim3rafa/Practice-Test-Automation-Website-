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

    @Test
    public void combinedFiltersTest() {
        // Implement test logic for combined filters in the table
        // Add assertions to verify the expected behavior
        tablepage.selectLanguage("Python");
        tablepage.selectLevel("Advanced");
        tablepage.setMinEnrollment("50,000+");
        // Verify that the table is filtered by all selected criteria
        Assert.assertTrue(tablepage.isLanguageFiltered("Python"));
        Assert.assertTrue(tablepage.isLevelFiltered("Advanced"));
        Assert.assertTrue(tablepage.isMinEnrollmentFiltered("50,000+"));
    }

    @Test
    public void noResultsTest() {
        // Implement test logic for no results scenario in the table
        // Add assertions to verify the expected behavior
        combinedFiltersTest();
        // Verify that the table shows no results
        Assert.assertTrue(tablepage.isNoResultsDisplayed());
    }

    @Test
    public void resetFiltersTest() throws InterruptedException {
        tablepage.selectLanguage("Java");
        tablepage.clickResetButton();
        Assert.assertFalse(tablepage.isLanguageFiltered("Any")); // Verify that the language filter is reset to "Any"
        Assert.assertFalse(tablepage.isLevelFiltered("Any")); // Verify that the level filter is reset to "Any"
        Assert.assertTrue(tablepage.isMinEnrollmentFiltered("Any"));
        Assert.assertFalse(tablepage.resetButtonIsVisible());  // Verify that the reset button is no longer visible after resetting filters
    }

    @Test
    public void sortByEnrollmentTest() {
        // Implement test logic for sorting by enrollment in the table
        // Add assertions to verify the expected behavior
        String[] sortOption = {"ID", "Course Name", "Language", "Level", "Enrollments"};
        tablepage.sortBy(sortOption[4]); // Sort by enrollment
        // Verify that the table is sorted by enrollment in ascending order
        Assert.assertTrue(tablepage.isSortedByEnrollmentAscending());
    }

    @Test
    public void sortByCourseNameTest() {
        // Implement test logic for sorting by course name in the table
        // Add assertions to verify the expected behavior
        String[] sortOption = {"ID", "Course Name", "Language", "Level", "Enrollments"};
        tablepage.sortBy(sortOption[1]); // Sort by course name
        // Verify that the table is sorted by course name in ascending order
        Assert.assertTrue(tablepage.isSortedByCourseNameAlphabetical());
    }
}
