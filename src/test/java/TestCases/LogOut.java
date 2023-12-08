package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class LogOut extends TestBase {

    @Test
    public void logout() throws Exception {

        Thread.sleep(75000);
       // driver.navigate().to("https://trackplantest.mineware.co.za/Account/LogonUser");
        clickButton("//a[text()='Logout']");
        Thread.sleep(2000);
       // clickButton("//*[@id=\"devextreme5\"]/div/i");
       // Thread.sleep(2000);
       // driver.navigate().to("https://trackplantest.mineware.co.za/trackplantestreports/home/viewer?reportName=EfficiencyReport");

    }
}
