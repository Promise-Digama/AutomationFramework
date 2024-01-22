package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class ViewTaskTest extends TestBase {

    @Test
    public void ViewTasks() throws Exception {

        Thread.sleep(10000);
        clickButton(OR.getProperty("ViewTaskMenu"));
        //driver.navigate().to("https://trackplantest.mineware.co.za/Tasks/TaskUserView");
        Thread.sleep(3000);
        clickButton(OR.getProperty("ProjectName")); //clicking project name
       // Thread.sleep(3000);
        clickButton(OR.getProperty("ActivityDropdown")); //click on activity dropdown
        Thread.sleep(3000);
        clickButton(OR.getProperty("Testingvalue"));
        Thread.sleep(1000);
       clickButton(OR.getProperty("CalenderIcon"));
       Thread.sleep(3000);
       clickButton(OR.getProperty("CalendarDate")); //click current date
        Thread.sleep(3000);
       clickButton(OR.getProperty("FromDate")); //Click fromDate
        Thread.sleep(3000);
        enterText(OR.getProperty("TotalHours"), "1"); //Enter hours
        Thread.sleep(1000);
        enterText(OR.getProperty("CommentField"), "t reyytrdia;'[p[h");
        Thread.sleep(3000);
        clickButton(OR.getProperty("SaveButton"));  //click save button

       // pressRefresh();
    }
}