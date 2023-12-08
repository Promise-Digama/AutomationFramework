package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

//import static sun.security.util.KnownOIDs.Data;

public class UsersTest extends TestBase {

    // https://trackplantest.mineware.co.za/Users/List

    @Test
    public void user() throws Exception {

       // Thread.sleep(3000);
      //  driver.navigate().to("https://trackplantest.mineware.co.za/Users/List");

       Thread.sleep(40000);
        clickButton("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'Projects')]");
       // clickButton("//*[@id='devextreme5']"); //click userButton /div[@class='d-flex flex-column text-muted']//a[normalize-space()='Projects']
       // clickButton("/html/body/div[5]/div/div/div[2]/div[3]/a");
        Thread.sleep(3000);
      /*  clickButton("//*[@id=\"ActivitySelectBoxContainer_LogTimeTaskUserView\"]/div[1]/div/div[1]/input"); //click on activity dropdown
        Thread.sleep(3000);
        clickButton("//div[contains(text(),'Testing')]");
        Thread.sleep(1000);
        clickButton("//*[@id=\"workdateBoxContainer_LogTimeTaskUserView\"]/div[1]/div/div[2]/div[2]/div");
        Thread.sleep(3000); */

    }

}













