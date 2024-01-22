package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class LogOut extends TestBase {

    @Test
    public void logout() throws Exception {

        Thread.sleep(170000);
       // driver.navigate().to("https://trackplantest.mineware.co.za/Account/LogonUser");
        clickButton(OR.getProperty("logOutbtn"));
        Thread.sleep(2000);

    }
}
