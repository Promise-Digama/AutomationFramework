package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class TimeSheetTest extends TestBase {

    @Test
    public void DeleteloggedTime() throws Exception {

        Thread.sleep(40000);
       clickButton("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'Time Sheet')]");
        Thread.sleep(3000);
        clickButton("//*[@id=\"UserTimeSheet\"]/div/div[6]/div[1]/div/div[1]/div/table/tbody/tr[2]/td[2]/div/a[2]/i");
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div/div[3]/div/div[2]/div[2]/div/div");
        Thread.sleep(3000);
        driver.navigate().refresh();
        }
    }










