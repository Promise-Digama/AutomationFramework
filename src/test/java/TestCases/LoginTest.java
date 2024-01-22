package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase { //All our test classes are going to extend testbase as a parent class

    @Test
    public void loginAsAdmin() throws Exception {
       log.info("Starting the loginAsAdmin test...");

        Thread.sleep(3000);
        pressRefresh();
        enterText(OR.getProperty("UsernameInput"), "promise@mineware.co.za");
        enterText(OR.getProperty("PasswordInput"), "Welcome1023!");
       // Assert.assertTrue(isElementPresent(By.xpath("//button[contains(text(),'LOGIN')]")),"Input username field not found");
        clickButton(OR.getProperty("LoginBtn"));
        Thread.sleep(3000);
       log.info("LoginAsAdmin test completed successfully :)");
    }
}




