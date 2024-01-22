package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class ReportsTest extends TestBase {

    @Test
    public void report() throws Exception {

        Thread.sleep(160000);
        clickButton(OR.getProperty("ReportMenu"));
        Thread.sleep(3000);
        driver.navigate().to("https://trackplantest.mineware.co.za/trackplantestreports/home/viewer?reportName=EfficiencyReport");
        Thread.sleep(3000);
        clickButton(OR.getProperty("ReportSubmitBtn"));
        Thread.sleep(6000);
       // driver.findElement(By.className("dx-context-menu dx-has-context-menu dx-widget dx-visibility-change-handler dx-collection"));

        driver.navigate().to(" https://trackplantest.mineware.co.za/Reports/Reports");
       // clickButton(OR.getProperty("//*[@id=\"DocumentViewer\"]/div/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/div[15]/div[1]/div/div/ul/li/div/div/div[2]"));
        Thread.sleep(3000);


    }
}
