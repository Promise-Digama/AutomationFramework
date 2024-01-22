package TestCases;

import BasePage.TestBase;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class BookLeaveTest extends TestBase {

    @Test
    public void SickLeave() throws Exception {

        Thread.sleep(100000);
        clickButton("//div[contains(@class,'d-flex flex-column text-muted')]//a[contains(text(),'Book Leave')]");
        Thread.sleep(3000);
        clickButton("//*[@id=\"devextreme2\"]/div[1]/div[2]/div[3]/div/div/div[1]/div/div/table/tbody/tr[3]/td[4]");
        clickButton("//*[@id=\"devextreme2\"]/div[1]/div[2]/div[3]/div/div/div[1]/div/div/table/tbody/tr[3]/td[4]");
        Thread.sleep(3000);
        clickButton("/html/body/div[13]/div/div[1]/div/div/div/div[1]/div[1]/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]");
        Thread.sleep(3000);
        clickButton("//div[contains(text(),'Sick Leave')]");
        Thread.sleep(3000);
       // clickButton(OR.getProperty("Description"));
        //Thread.sleep(3000);
        enterText(OR.getProperty("Description"), "Just testing sick leave");
       Thread.sleep(3000);
       clickButton(OR.getProperty("DoneBtn"));
       Thread.sleep(4000);
       clickButton("//*[@id=\"LetterFileUploader\"]/div/div/div/div[1]/div[1]");
       Thread.sleep(6000);
        String filePath = System.getProperty("user.dir") + "\\Sick note.docx"; //("user.dir") +
        Thread.sleep(1000);
        // Use the Robot class to upload the file
        uploadFile(filePath);
        Thread.sleep(3000);
        clickButton("//*[@id=\"LetterFileUploader\"]/div/div/div/div[2]");
        Thread.sleep(3000);
        clickButton("//*[@id=\"devextreme2\"]/div/div[2]/div[3]/div/div/div[1]/div/div/div/div[1]");
        Thread.sleep(3000);
        clickButton("//div[@class='dx-button-content' and descendant::i[@class='dx-icon dx-icon-trash']]");
        Thread.sleep(3000);
        // Continue with the rest of your test case
    }

    private void uploadFile(String filePath) {
        try {
            // Copy file path to clipboard
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // Use Robot class to handle keyboard events
            Robot robot = new Robot();

            // Press Enter to open file dialog
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);

            // Paste file path from clipboard
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);

            // Press Enter to select the file
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




