package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase { //All our test classes are going to extend testbase as a parent class

    @Test
    public void loginAsAdmin() throws Exception {

        Thread.sleep(3000);
        pressRefresh();
        enterText("//input[@id='Email']", "promise@mineware.co.za");
        enterText("//input[@id='Password']", "Welcome1023!");
        clickButton("//button[contains(text(),'LOGIN')]");
        Thread.sleep(6000);
    }
}




