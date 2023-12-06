package TestCases;

import BasePage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ViewTaskTest extends TestBase {


    @Test
    public void ViewTasks() throws InterruptedException {

        try {
            Thread.sleep(10000);
            driver.findElement(By.xpath(OR.getProperty("ViewTaskLink_Xpath"))).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

            // Adding a delay after clicking "ViewTaskLink" (replace with WebDriverWait for better practices)
           Thread.sleep(3000);
        String xpath = "//*[@id=\"TaskViewgridContainer\"]/div/div[6]/div/table/tbody/tr[4]/td[2]";
        System.out.println("XPath: " + xpath);
        driver.findElement(By.xpath(xpath)).click();

        Thread.sleep(3000);
        //WebElement inputField = driver.findElement(By.xpath(OR.getProperty("ActivityDropdown_Xpath")));
       // inputField.clear();
       // Thread.sleep(3000);
       // inputField.sendKeys("Testing");
       Thread.sleep(3000);
      //  driver.findElement(By.xpath(OR.getProperty("Testingvalue_Xpath"))).click();

        WebElement calendar = driver.findElement(By.xpath(OR.getProperty("CalenderIcon_Xpath")));
        calendar.click();

        // Wait for the datepicker to appear
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       // WebElement datepicker = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("CalenderIcon_Xpath")));

        // Select the desired date in the datepicker
       // WebElement desiredDate = datepicker.findElement(By.xpath("CalendarDate_Xpath"));
      //  desiredDate.click();

        Thread.sleep(3000);
        String dateInputXpath = "//input[@role='combobox' and @class='dx-texteditor-input' and @aria-activedescendant][@aria-controls]";
        WebElement dateInput = driver.findElement(By.xpath(dateInputXpath));
        dateInput.click();

        driver.findElement(By.xpath(OR.getProperty("FromTime_Xpath"))).click();

       WebElement InputHours = driver.findElement(By.xpath(OR.getProperty("TotalHours_Xpath")));
       InputHours.clear();
       InputHours.sendKeys("1");
       Thread.sleep(3000);
       driver.findElement(By.xpath(OR.getProperty("CommentTextbox_Xpath"))).sendKeys("Just testing");
        Thread.sleep(10000);
       driver.findElement(By.xpath(OR.getProperty("SaveButton_Class"))).click();


    }

}
