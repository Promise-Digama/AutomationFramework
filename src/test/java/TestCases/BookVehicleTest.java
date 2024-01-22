package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class BookVehicleTest extends TestBase {

    @Test
    public void client() throws Exception {

        Thread.sleep(60000);
        //Thread.sleep(3000);
        clickButton(OR.getProperty("ClientMenu"));
        Thread.sleep(3000);
        clickButton("//*[@id=\"vehicleBookingScheduler\"]/div[1]/div[2]/div[3]/div/div/div[1]/div/div/table/tbody/tr[3]/td[3]");
        clickButton("//*[@id=\"vehicleBookingScheduler\"]/div[1]/div[2]/div[3]/div/div/div[1]/div/div/table/tbody/tr[3]/td[3]");
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div[1]/div/div/div/div[1]/div[1]/div/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]/div");
        Thread.sleep(3000);
        clickButton("(//div[contains(text(),'Old Ford Ranger')])[2]"); //click ford ranger
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]"); //click dropdown icon
        Thread.sleep(3000);
       clickButton("//div[contains(text(),'Alex Caudron')]");
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div[1]/div/div/div/div[1]/div[1]/div/div/div[3]/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]");
        Thread.sleep(3000);
        clickButton("//td[@aria-label='Wednesday, January 17, 2024']");
        Thread.sleep(3000);
        clickButton("/html/body/div[14]/div/div[2]/div/div[3]/div[2]/div/div"); //clickCancel
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div[2]/div/div[3]/div[1]/div/div"); //ClickDone
        Thread.sleep(3000);
        clickButton("/html/body/div[14]/div/div/div[3]/div/div[2]/div[1]/div/div");
        Thread.sleep(1000);



    }
}
