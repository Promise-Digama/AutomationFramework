package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class Projects extends TestBase {


    @Test
    public void NewProject() throws Exception {

        Thread.sleep(140000);
        clickButton(OR.getProperty("ProjectMenu"));

       Thread.sleep(3000);
        clickButton(OR.getProperty("NewProjectButton"));  //Click on Project button
        Thread.sleep(3000);
        enterText(OR.getProperty("Title"), "Automation Project");
        Thread.sleep(1000);
        clickButton(OR.getProperty("DropdownClient"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("Client"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("DropdownProjectLeader"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("ProjectLeader"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("DropdownProjectScope"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("ProjectScope"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("ClickCalendarIcon"));
        Thread.sleep(1000);
        clickButton(OR.getProperty("StartDate"));
        //Thread.sleep(1000);
        Thread.sleep(1000);
        clickButton(OR.getProperty("CalendarIcon"));
        Thread.sleep(2000);
        clickButton(OR.getProperty("EndDate"));
        Thread.sleep(2000);
        clickButton(OR.getProperty("AddProjectbtn"));
        //pressRefresh();
        Thread.sleep(1000);




       // Thread.sleep(1000);
      /*  enterText("//*[@id=\"dx_dx-60eb636c-6051-ae62-1b4e-b7735aeab5d6_Title\"]" , "Automation Project"); //Enter project tittle
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div"); //choose project name from dropdown
        Thread.sleep(1000);
        clickButton("//div[contains(text(),'Goldfields')]");
        Thread.sleep(1000); */
    }
}




