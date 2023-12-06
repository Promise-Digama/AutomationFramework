package TestCases;

import BasePage.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.testUtil;

//import static sun.security.util.KnownOIDs.Data;

public class UsersTest extends TestBase {

    @Test  (dataProviderClass = testUtil.class, dataProvider = "dp")
    public void user (String firstname, String lastname, String postcode) throws InterruptedException {

        //if(runmode.equalsIgnoreCase("Y")) {

         // throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        Thread.sleep(10000);
        driver.findElement(By.xpath(OR.getProperty("Users_Xpath"))).click();
        System.out.println("//div[@class='d-flex flex-column text-muted']//a[normalize-space()='Users']");
        Thread.sleep(3000);
       driver.findElement(By.xpath(OR.getProperty(""))).sendKeys(firstname);
        Thread.sleep(3000);
       driver.findElement(By.xpath(OR.getProperty(""))).sendKeys(lastname);
        Thread.sleep(3000);
       driver.findElement(By.xpath(OR.getProperty(""))).sendKeys(postcode);
       Thread.sleep(3000);
      // Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    }

    @DataProvider (name = "dp")// This method should provide data for your test
    public Object[][] data() {


        return new Object[][] {

                {"Testing", "tester", "Mineware", "User", "Y"},
                {"Jane", "Smith", "Mineware", "Error", "N"},
                {"P", "D", "Mineware", "Error", "N"},
                {"Leago", "Digama", "Mineware", "Error", "N"},

        };


    }
}

            //public void getData (String firstname, String lastname, String postcode, String alerttext) throws InterruptedException {

                // You need to return a 2D array of test data
            // For example, you can read data from a file or a database here
            // Thread.sleep(3000);


        /*click("addCustBtn_CSS");
        type("firstname_CSS",data.get("firstname"));
        type("lastname_XPATH",data.get("lastname"));
        type("postcode_CSS",data.get("postcode"));
        click("addbtn_CSS");
        Thread.sleep(2000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept(); */

            //   Thread.sleep(2000);











