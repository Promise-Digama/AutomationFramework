package BasePage;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.extentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties(); //used to store configurations
    public static Properties OR = new Properties(); //used to store object repository
   // public static Logger log = Logger.getLogger("devpinoyLogger");
   public static Logger log = Logger.getLogger(String.valueOf(TestBase.class));//declares a static variable log of type logger from  log4j library, which is used for logging in the test script
  //  public static ExcelReader excel = new ExcelReader("C:\\Users\\Promise Digama\\IdeaProjects\\Mineware\\src\\main\\resources\\excel\\testdata.xlsx"); //initializes an ExcelReader object for reading test data from an excel file.
    public static FileInputStream fis; //used to read property files
    public static WebDriverWait wait; //used to wait for elements in the web page to load
    public static WebElement dropdown;
    public static String browser; //declares a static variable browser to store the web browser name
    public extentManager ExtentManager;
    //public ExtentReports reports = extentManager.getInstance();
    public static ExtentTest test;
    public static Assert Anassert;


    @BeforeSuite
//method to set up everything
    public void setUp() {

        if (driver == null) {

            PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\log4j.properties.txt");
            log = Logger.getLogger(String.valueOf(TestBase.class)); //"\\src\\test\\java\\MyRough\\log4j.properties.txt"

            //This conditional block checks if the WebDriver instance is not already initialized
            log.info("Initializing WebDriver....");
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\TestData.properties.txt"); //I have concatenated this file path using System.getProperty("user.dir") to allow others to access the file  even on their local machines.
            } catch (FileNotFoundException e) {
                e.printStackTrace(); //TODO Auto-generated catch block
            }
            try {
                config.load(fis);
                log.config("Config file Loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\OR.properties.txt"); //I have concatenated this file path using System.getProperty("user.dir") to allow others to access the file  even on their local machines.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
                log.config("OR file loaded !!!");

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) { //This code checks if a browser is specified as an environment variable and uses it. Otherwise, it falls back to the browser specified in the configuration properties.

                browser = System.getenv("browser");
            } else {

                browser = config.getProperty("browser");

            }

            config.setProperty("browser", browser); //This sets the browser property in the configuration properties.


            //System.out.println(config.getProperty("browser"));
            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.config("Chrome Launched !!!");


            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

                /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\gecko.exe");  */
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();


            } else if (config.getProperty("browser").equalsIgnoreCase("edge")) {

                  /* System.setProperty("webdriver.edge.driver",
                            System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\msedgedriver.exe"); */
                driver = new EdgeDriver();
            }

            driver.get(config.getProperty("testsiteurl")); //this opens the URL specified in the confagurations
            log.config("Navigated to : " + config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            log.info("WebDriver initialized successfully.");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

            wait = new WebDriverWait(driver, Duration.ofSeconds(45));
            // try {
            //driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
            // wait = new WebDriverWait( driver, Duration.ofSeconds(10));

            // }catch (DateTimeParseException e){
            // System.out.println("Error parsing duration:" + e.getMessage());
        }
    }


    public static void clickButton(String xPath) throws InterruptedException {
        WebElement button = null;
        boolean found = false;
        do {
            found = true;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                button = driver.findElement(By.xpath(xPath));
            } catch (NoSuchElementException e) {
                found = false;
            } catch (StaleElementReferenceException e) {
                // button = driver.findElement(By.xpath(xPath));

                // element = driver.findElement(By.xpath(xPath));

                //remove later
                int attempts = 0;
                int MAX_RETRY = 20;
                while (attempts < MAX_RETRY) {
                    try {
                        button = driver.findElement(By.xpath(xPath));
                        break; // If the action was successful, exit the loop
                    } catch (StaleElementReferenceException ex) {
                        // Handle the exception or log it if needed
                        attempts++;
                    }
                }
                //remove until here
            }
        } while (!found);
        button.click();
        System.out.println("Successfully clicked " + xPath);
    }

    public static void enterText(String xPath, String text) throws Exception {
        WebElement txt = null;
        boolean found = false;
        do {
            found = true;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                txt = driver.findElement(By.xpath(xPath));
            } catch (NoSuchElementException e) {
                found = false;
            } catch (StaleElementReferenceException e) {
                // txt = driver.findElement(By.xpath(xPath));
                // element = driver.findElement(By.xpath(xPath));

                //remove later
                int attempts = 0;
                int MAX_RETRY = 20;
                while (attempts < MAX_RETRY) {
                    try {
                        txt = driver.findElement(By.xpath(xPath));
                        break; // If the action was successful, exit the loop
                    } catch (StaleElementReferenceException ex) {
                        // Handle the exception or log it if needed
                        attempts++;
                    }
                }
                //remove until here
            }
        } while (!found);
        txt.sendKeys(text);
        System.out.println("Successfully entered text: " + text);

    }

    public static void clearElement(String xPath) throws Exception {
        WebElement element = null;
        boolean found = false;
        do {
            found = true;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                element = driver.findElement(By.xpath(xPath));
            } catch (NoSuchElementException e) {
                found = false;
            } catch (StaleElementReferenceException e) {
                // element = driver.findElement(By.xpath(xPath));

                //remove later
                int attempts = 0;
                int MAX_RETRY = 20;
                while (attempts < MAX_RETRY) {
                    try {
                        element = driver.findElement(By.xpath(xPath));
                        break; // If the action was successful, exit the loop
                    } catch (StaleElementReferenceException ex) {
                        // Handle the exception or log it if needed
                        attempts++;
                    }
                }
                //remove until here
            }
        } while (!found);
        element.clear();
        System.out.println("Successfully cleared element: " + xPath);
    }

    public static void pressReturn(String xPath) throws Exception {
        WebElement key = null;
        boolean found = false;
        do {
            found = true;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                key = driver.findElement(By.xpath(xPath));
            } catch (NoSuchElementException e) {
                found = false;
            } catch (StaleElementReferenceException e) {
                key = driver.findElement(By.xpath(xPath));
            }
        } while (!found);
        // key.sendKeys(Keys.TAB);
        key.sendKeys(Keys.RETURN);
        System.out.println("Successfully pressed return key on : " + xPath);
    }

    public static void pressRefresh() {
        try {
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.F5).perform();
            actions.release().perform();
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void MoveOnElement(String xPath) {
        WebElement key = null;
        boolean found = false;
        do {
            found = true;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                key = driver.findElement(By.xpath(xPath));
            } catch (NoSuchElementException e) {
                found = false;
            } catch (StaleElementReferenceException e) {
                key = driver.findElement(By.xpath(xPath));
            }
        } while (!found);
        // key.sendKeys(Keys.TAB);
        key.sendKeys(Keys.DOWN);
        System.out.println("Successfully pressed return key on : " + xPath);
            }

    public static void handleAlert(String xPath) {
        try {
            driver.switchTo().frame(xPath);
           // Alert alert = driver.switchTo().alert();
          //  alert.accept();
        } catch (Exception e) {
            System.out.println(e);
            // No alert present, do nothing
        }
    }

    public static void doubleClick(String xPath){
        WebElement key = null;
        key = driver.findElement(By.xpath(xPath));
        try {
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(By.xpath(xPath));
            actions.moveToElement(element).doubleClick().perform();
            Thread.sleep(1000);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public boolean isElementPresent (By by) { //use this methods for assertions

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {


            return false;
        }
    }
    @AfterSuite //this will be run after we execute all our testcases
    //Method to close everything
    public void tearDown() {
        try {
            if (driver != null) {
              //  driver.quit();
                log.config("WebDriver closed successfully.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error during tearDown."+ e.getMessage());
        }
    }

}


