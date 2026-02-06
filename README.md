# 🤖 Practice Test Automation (Selenium + TestNG)

This repository contains an automated test suite for the Practice Test Automation demo site (https://practicetestautomation.com/practice/) implemented with Java, Selenium WebDriver, and TestNG.

---

## 📌 Project Overview

The goal is to validate key UI flows on the practice site using a Page Object Model (POM) and TestNG. Tests are organized by feature (Login, Table, Exceptions). This README highlights the `Table` tests and how to run and troubleshoot them.

---

## 🛠 Tech Stack

- Java (JDK 11+)
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- IntelliJ IDEA (recommended)

---

## 📂 Project Structure

```bash
src
├── main
│   └── java
│       └── Pages
│           ├── loginPage.java
│           ├── tablePage.java
│           └── exceptionPage.java
└── test
    └── java
        ├── Base
        │   └── baseTest.java
        ├── Login
        │   └── loginTests.java
        ├── Table
        │   └── tableTests.java
        └── Exceptions
            └── exceptionTests.java

pom.xml
target/
```

---

## ▶️ Table Tests (detailed)

The `Table` test suite is implemented in `src/test/java/Table/tableTests.java` and exercises the filtering, reset, and sorting functionality of the "Test Table" page.

Test cases included:

- `languageFilterTest`
  - Selects a language (e.g., Java) and verifies the table rows are filtered to show only that language.

- `levelFilterTest`
  - Selects a level (e.g., Beginner) and verifies rows are filtered accordingly.

- `minEnrollmentFilterTest`
  - Sets the minimum enrollment filter (e.g., "10,000+") and verifies only rows that meet or exceed that threshold are visible.

- `combinedFiltersTest`
  - Applies language, level, and minimum enrollment simultaneously and verifies rows satisfy all selected criteria.

- `noResultsTest`
  - Uses a filter combination expected to produce no results and verifies the UI indicates no records found.

- `resetFiltersTest`
  - Applies filters, clicks the Reset button, and verifies filters and UI return to their default states.
  - Note: the test expects the Reset button to disappear after resetting.

- `sortByEnrollmentTest`
  - Sorts the table by enrollment and verifies results are ordered (ascending) by the enrollment column.

- `sortByCourseNameTest`
  - Sorts the table by course name and verifies alphabetical ordering.

These tests rely on `Pages/tablePage.java` for encapsulated interactions and assertions such as `selectLanguage`, `selectLevel`, `setMinEnrollment`, `sortBy`, and the corresponding verification helpers.

---

## ▶️ Test Flow (high level)

1. Start ChromeDriver and open https://practicetestautomation.com/practice/
2. Click the link to open the Test Table page
3. Use the `tablePage` Page Object to interact with filters and sorting controls
4. Assert expected table contents, visibility, and ordering
5. Tear down WebDriver

---

## 🧪 Running Table Tests

### Run the entire table test class

From the repository root (where `pom.xml` is), run (Windows - cmd.exe):

```bash
mvn -Dtest=Table.tableTests test
```

### Run a single test method

To run only the `languageFilterTest` method:

```bash
mvn -Dtest=Table.tableTests#languageFilterTest test
```

Or run any other single method by replacing the method name.

### Run all tests

```bash
mvn clean test
```

---

## 🔧 Table-specific Troubleshooting & Notes

- Timing and waits
  - Table operations may mutate the DOM (filtering/hiding rows). If tests are flaky, increase the `WebDriverWait` timeout in `baseTest` or add explicit waits in `tablePage` for the expected row count or a stable DOM state.

- Locators
  - If the site structure changes, update the selectors in `src/main/java/Pages/tablePage.java`.

- Reset behavior
  - `resetFiltersTest` expects the Reset button to become hidden after reset and filters to become `Any`. If the UI differs, update the test expectations.

- Sorting validation
  - Sorting tests compare visible row values. Ensure `tablePage` verification helper parses enrollment numbers correctly (remove commas, convert to integers) before asserting order.

- Environment
  - Ensure `chromedriver.exe` matches your Chrome version and is on your PATH or pass its path:

```bash
mvn -Dwebdriver.chrome.driver="C:\path\to\chromedriver.exe" test
```

- `baseTest` notes
  - `baseTest` performs a navigation assertion on the landing page header and uses a short default wait. Adjust as needed for your environment.

---

## ✅ Key Features (project-wide)

- Page Object Model (POM) for maintainable UI interactions
- TestNG test organization (suites, before/after hooks)
- Clear separation between page logic and tests
- Easy to run locally with Maven

---

## 🚀 Suggested Improvements

- Integrate WebDriverManager to manage browser drivers automatically
- Add CI (GitHub Actions / Azure Pipelines) to run tests on push/PR
- Add more assertions and negative-case coverage for the Table features
- Generate HTML reports (Allure / Surefire / ReportNG)

---

## 👤 Author

Ibrahim Arafa — Junior Software Tester | ISTQB® Certified Tester (CTFL & MAT)

Manual Testing • Automation Testing • API Testing
