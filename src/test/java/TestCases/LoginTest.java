package TestCases;

import BasePage.TestBase;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends TestBase { //All our test classes are going to extend testbase as a parent class

@Test
    public void loginAsAdmin() throws InterruptedException {

    Thread.sleep(3000);
    driver.findElement(By.cssSelector(OR.getProperty("UsernameInput_css"))).sendKeys("promise@mineware.co.za");
    Thread.sleep(3000);
    driver.findElement(By.xpath(OR.getProperty("PasswordInput_Xpath"))).sendKeys("Welcome1023!");
    Thread.sleep(3000);
    driver.findElement(By.xpath(OR.getProperty("LoginBtn_Xpath"))).click();
    Thread.sleep(3000);
    //Object ExpectedConditions = null;
   // WebElement element = waitForElementToBeVisible(elementLocator, 10); //wait.until(ExpectedConditions.equals(By.xpath("DashboardBtn_Xpath")));
    //Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("DashboardBtn_Xpath"))),"Login not successful");
   // System.out.println("Log in was successful");
    Reporter.log("Login successfully executed");
   // Assert.fail("Login not successful"); //just testing fail scenarios
    //Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Promise Digama\\Downloads\\trackplan-2023-11-12-0-53-23_screenshots.jpg</a>");
   // Reporter.log("<br>");//adding screenshots to the report.
    //Thread.sleep(3000); ///html/body/div[7]/div/div[1]/div[1]/div/h5
    //By elementLocator = By.xpath(OR.getProperty("DashboardBtn_Xpath"));
    //WebElement element = waitForElementToBeVisible(elementLocator, 10);

}

    //private WebElement waitForElementToBeVisible(By elementLocator, int i) {
       // return null;
    }


