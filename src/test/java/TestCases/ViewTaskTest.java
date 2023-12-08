package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

public class ViewTaskTest extends TestBase {

    @Test
    public void ViewTasks() throws Exception {

        Thread.sleep(10000);
        clickButton("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'View Tasks')]");
        //driver.navigate().to("https://trackplantest.mineware.co.za/Tasks/TaskUserView");
        Thread.sleep(3000);
       // MoveOnElement("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'Projects')]");

        clickButton("//*[@id='TaskViewgridContainer']/div/div[6]/div/table/tbody/tr[4]/td[2]"); //clicking project name
       // Thread.sleep(3000);
        clickButton("//*[@id=\"ActivitySelectBoxContainer_LogTimeTaskUserView\"]/div[1]/div/div[1]/input"); //click on activity dropdown
        Thread.sleep(3000);
        clickButton("//div[contains(text(),'Testing')]");
        Thread.sleep(1000);
       clickButton("//*[@id=\"workdateBoxContainer_LogTimeTaskUserView\"]/div[1]/div/div[2]/div[2]/div");
       Thread.sleep(3000);
       clickButton("/html/body/div[13]/div/div/div/div[2]/div/div/table/tbody/tr[4]/td[3]"); //click current date
        Thread.sleep(3000);
       clickButton("//*[@id=\"StartTimeBoxContainer_LogTimeTaskUserView\"]/div/div/div[1]/input"); //Click fromDate
        Thread.sleep(3000);
        enterText("//*[@id=\"TotalTimeBoxContainer_LogTimeTaskUserView\"]/div[1]/div[1]/input" , "1"); //Enter hours
        Thread.sleep(1000);
        enterText(" //*[@id=\"CommentsBoxContainer_LogTimeTaskUserView\"]/div/div[1]/textarea" , "tt d67jkh");
        Thread.sleep(3000);
        clickButton("//div[@id='SaveButtonContainer_LogTimeTaskUserView']//div[@class='dx-button-content']");  //click save button

        pressRefresh();
    }
}