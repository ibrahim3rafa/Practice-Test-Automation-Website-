Practice Test Automation
========================

Project overview
----------------
This repository contains a small Selenium + TestNG automated test suite (Java, Maven) for the Practice Test Automation demo site (https://practicetestautomation.com/practice/).

The tests exercise the following areas:
- Login page tests (src/test/java/Login)
- Table filtering / sorting tests (src/test/java/Table)
- Exception-handling related tests (src/test/java/Exceptions)

Page objects live under src/main/java/Pages and TestNG test classes under src/test/java.

Prerequisites
-------------
- Java JDK 11 or newer installed and JAVA_HOME configured.
- Apache Maven installed and mvn on your PATH.
- Google Chrome browser installed.
- ChromeDriver executable compatible with your Chrome version available on your PATH, or provide its path via the system property (see Troubleshooting).

Note: This project currently creates a ChromeDriver directly in the base test (no WebDriverManager). Make sure chromedriver.exe is accessible.

Quick setup (Windows - cmd.exe)
-------------------------------
1. Open a Windows command prompt (cmd.exe).
2. From the repository root (where pom.xml is located):

   mvn clean test

This will compile the project and run the TestNG suite using the surefire plugin.

Running specific tests
----------------------
- Run a single test class:

  mvn -Dtest=Login.loginTests test

- Run a single test method in a class:

  mvn -Dtest=Login.loginTests#validLoginTest test

Adjust package-qualified class names as needed (e.g., Table.tableTests).

Project layout
--------------
- pom.xml — Maven project file
- src/main/java/Pages — Page Object classes (loginPage, tablePage, exceptionPage)
- src/test/java/Base — baseTest (startup/shutdown / WebDriver setup)
- src/test/java/Login, /Table, /Exceptions — TestNG test classes
- target — build output and test reports (target/surefire-reports)

Troubleshooting
---------------
- ChromeDriver not found / WebDriver errors:
  - Download a chromedriver.exe that matches your Chrome version and either place it on your PATH or pass its full path to the JVM before running tests:

    mvn -Dwebdriver.chrome.driver="C:\path\to\chromedriver.exe" test

  - Alternatively, install and configure WebDriverManager (recommended) and update baseTest to use it.

- Failing assertions / locators:
  - Verify the target site URL is reachable: https://practicetestautomation.com/practice/
  - Page locators live in src/main/java/Pages — check them if tests start failing after site updates.

Test reports
------------
After running tests, basic XML/text reports are available in target/surefire-reports. Open the console output for quick pass/fail details.

Contributing
------------
1. Open an issue describing the change or bug.
2. Fork, create a feature branch, make changes and add/update tests.
3. Submit a pull request.

Notes and next steps
--------------------
- Consider switching to WebDriverManager to avoid manual ChromeDriver management.
- Add CI integration (GitHub Actions / Azure Pipelines) to run tests automatically.

License
-------
This repository does not include a license file. Add one if you intend to publish or share the code.

Maintainer
----------
Repository owner / author: (update with your name and contact info)

