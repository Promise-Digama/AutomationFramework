package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class Projects extends TestBase {


    @Test
    public void BookLeave() throws Exception {

        Thread.sleep(48000);
        clickButton("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'Projects')]");

       Thread.sleep(3000);
        clickButton("//*[@id=\"btnProjectTask\"]/div/i");  //Click on Project button
        Thread.sleep(3000);
       // handleAlert  ("//div[@id='NewProject']"); //Switch to Alert
        enterText("//input[@name='Title']" , "Automation Project");
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]");
        Thread.sleep(1000);
        clickButton("//div[contains(text(),'Goldfields')]");
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[3]/div/div/div/div/div[1]/div/div[2]/div[2]");
        Thread.sleep(1000);
        clickButton("//div[contains(text(),'Alex Caudron')]");
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[4]/div/div/div/div/div/div/div[2]/div[2]");
        Thread.sleep(1000);
        clickButton("//div[contains(text(),'Retainer')]");
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[5]/div/div/div/div/div/div/div[2]/div[2]");
        Thread.sleep(1000);
        clickButton("//td[@aria-label='Monday, December 18, 2023']");
        //Thread.sleep(1000);
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[6]/div/div/div/div/div/div/div[2]/div[2]");
        Thread.sleep(2000);
        clickButton("(//td[@data-value='2023/12/19'])[2]");
        Thread.sleep(2000);
        clickButton("//div[@aria-label='Add Project']");
        pressRefresh();
        //Thread.sleep(1000);




       // Thread.sleep(1000);
      /*  enterText("//*[@id=\"dx_dx-60eb636c-6051-ae62-1b4e-b7735aeab5d6_Title\"]" , "Automation Project"); //Enter project tittle
        Thread.sleep(1000);
        clickButton("//*[@id=\"addNewProjectForm\"]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div"); //choose project name from dropdown
        Thread.sleep(1000);
        clickButton("//div[contains(text(),'Goldfields')]");
        Thread.sleep(1000); */
    }
}




