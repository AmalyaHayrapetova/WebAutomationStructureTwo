package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
@Listeners(value = AutomationListener.class)
public class Driver implements IHookable {
    static ExtentTest test;
    static ExtentReports report;

    public WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static final String REMOTE = System.getProperty("selenium.remote", "false");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal();
    private final Logger LOGGER = Logger.getLogger(Driver.class);

//    @BeforeClass
//    public WebDriver getWebDriver(Browser browser) {
//        if (driverThread.get() == null) {
//            switch (browser) {
//                case chrome:
//                    System.setProperty("webdriver.chrome.driver",
//                            "/Users/amalyahayrapetova/Desktop/mobile_automation/WebAutomationStructureTwo/src/main/resources/drivers/chromedriver");
//                    if (Boolean.valueOf(REMOTE)) {
//                        driver = initRemoteDriver(DesiredCapabilities.chrome());
//                    } else {
//                        driver = new ChromeDriver();
//                    }
//                    driverThread.set(driver);
//                    break;
//                case firefox:
//                    break;
//            }
//        }
//
//        return driverThread.get();
//    }

    @BeforeClass(alwaysRun = true)
    public void setUpWebDriver() {
        if (driverThread.get() == null) {

            System.setProperty("webdriver.chrome.driver",
                    "/Users/amalyahayrapetova/Desktop/mobile_automation/WebAutomationStructureTwo/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driverThread.set(driver);
        }

    }


    public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return remoteDriver;
    }

    public static Driver get() {
        return new Driver();
    }

//    @AfterClass(alwaysRun = true)
//    public void quiteDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//            driverThread.remove();
//        }
//    }


    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            takeScreenShot(testResult.getMethod().getQualifiedName());
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) {
        LOGGER.info("Taking screenshot on failure");
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}