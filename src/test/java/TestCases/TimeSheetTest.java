package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class TimeSheetTest extends TestBase {

    @Test
    public void DeleteloggedTime() throws Exception {

        Thread.sleep(45000);
       clickButton(OR.getProperty("TimesheetMenu"));
        Thread.sleep(3000);
        clickButton(OR.getProperty("UserCalendar"));
        Thread.sleep(3000);
        clickButton(OR.getProperty("DateInput"));
        Thread.sleep(3000);
       // driver.navigate().refresh();
        }
    }










