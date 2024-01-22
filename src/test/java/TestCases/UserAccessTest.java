package TestCases;

import BasePage.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ExcelReader;

public class UserAccessTest extends TestBase {

    @Test // (invocationCount = 2, threadPoolSize = 1)
    public void MultipleUsers() throws Exception {

        // Specify the path to the Excel file and sheet name
        String excelFilePath = "C:\\Users\\Promise Digama\\IdeaProjects\\Mineware\\src\\main\\resources\\excel\\testdata.xlsx";
        String sheetName = "testdata"; // Change to your actual sheet name

        // Create an ExcelReader instance
        ExcelReader excelReader = new ExcelReader(excelFilePath, sheetName);

        // Get data from Excel
        Object[][] testData = excelReader.readExcelData();

        // Run the test with Chrome
        runTest(testData, "chrome");

    }

    private void runTest(Object[][] testData, String browser) throws Exception {

        String driverPath = "";
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driverPath = String.valueOf(WebDriverManager.chromedriver());
       // } else if (browser.equalsIgnoreCase("edge")) {
          //  WebDriverManager.edgedriver().setup();
          //  driverPath = String.valueOf(WebDriverManager.edgedriver());

        // Create a new WebDriver instance for the specified browser
      //  WebDriver driver;
      //  if (browser.equalsIgnoreCase("chrome")) {
        //    driver = new ChromeDriver();
       // } else if (browser.equalsIgnoreCase("edge")) {
          //  driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Iterate through rows and test login functionality
        for (Object[] data : testData) {
            String username = data[0].toString();
            String password = data[1].toString();

            // Perform login
            testLogin(driver, username, password);

        }
    }


    // The testLogin method remains the same as in the previous example
    private static void testLogin(WebDriver driver, String username, String password) throws Exception {
        System.out.println("Logging in with username: " + username + " and password: " + password);
        Thread.sleep(3000);
        TestBase.driver.findElement(By.xpath(OR.getProperty("UsernameInput"))).sendKeys(username);
        Thread.sleep(3000);
        TestBase.driver.findElement(By.xpath(OR.getProperty("PasswordInput"))).sendKeys(password);
      //  driver.findElement(By.id("Username")).sendKeys(username);
     //   driver.findElement(By.id("Password")).sendKeys(password);
        Thread.sleep(3000);
        TestBase.driver.findElement(By.xpath(OR.getProperty("LoginBtn"))).click();
        log.info("LoginAsAdmin test completed successfully :)");
        Thread.sleep(10000);
        clickButton(OR.getProperty("logOutbtn"));
        Thread.sleep(2000);
        // ... (unchanged)

    }
}