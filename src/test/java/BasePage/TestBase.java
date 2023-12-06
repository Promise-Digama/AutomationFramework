package BasePage;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelReader;
import utilities.extentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties(); //used to store configurations
    public static Properties OR = new Properties(); //used to store object repository
    public static Logger log = Logger.getLogger(String.valueOf(TestBase.class)); //declares a static variable log of type logger from  log4j library, which is used for logging in the test script
   public static ExcelReader excel = new ExcelReader(".//src//main//resources//excel//testdata.xlsx"); //initializes an ExcelReader object for reading test data from an excel file.
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
            } try {
            OR.load(fis);
            log.config("OR file loaded !!!");

        }catch (IOException e) {
                e.printStackTrace();
            }

            if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){ //This code checks if a browser is specified as an environment variable and uses it. Otherwise, it falls back to the browser specified in the configuration properties.

                browser = System.getenv("browser");
            }else{

                browser = config.getProperty("browser");

            }

            config.setProperty("browser", browser); //This sets the browser property in the configuration properties.




            //System.out.println(config.getProperty("browser"));
                if (config.getProperty("browser").equals("chrome")) {

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    log.config("Chrome Launched !!!");


                } else if (config.getProperty("browser").equals("firefox")) {

                    /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\gecko.exe");  */
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();


                } else if (config.getProperty("browser").equals("ie")) {

                   /* System.setProperty("webdriver.ie.driver",
                            System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\IEDriverServer.exe"); */
                    driver = new InternetExplorerDriver();
                }
                driver.get(config.getProperty("testsiteurl")); //this opens the URL specified in the confagurations
                log.config("Navigated to : " + config.getProperty("testsiteurl"));
                driver.manage().window().maximize();
                log.info("WebDriver initialized successfully.");
                try {
                    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
                    wait = new WebDriverWait( driver, Duration.ofSeconds(10));
                }catch (DateTimeParseException e){
                  System.out.println("Error parsing duration:" + e.getMessage());
                }
            }
    }

public boolean isElementPresent(By by) {

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
                driver.quit();
                log.config("WebDriver closed successfully.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error during tearDown."+ e.getMessage());
        }
    }

}






