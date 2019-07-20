package utilities;

import exceptions.ElementNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static final Logger LOGGER = Logger.getLogger(WaitUtils.class);
    static WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    private static boolean waitUntilConditions(By by, int timeInSeconds, int type) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            switch (type) {

                case 0: //appear
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                    break;
                case 1: //disappear
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
                    break;
                case 2: //clickable
                    wait.until(ExpectedConditions.elementToBeClickable(by));
                    break;
                case 3: //visible
                    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                    break;
            }
        } catch (TimeoutException ex) {
            throw new ElementNotFoundException(by.toString());
        }
        return true;
    }

    public static boolean waitUntilElementAppear(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 0);
    }

    public boolean waitUntilElementTextToBe(By by, int timeInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.textToBe(by, text));
    }

    public static boolean waitUntilElementAppear(By by) {
        return waitUntilConditions(by, 45, 0);
    }

    public WebElement waitUntilElementAppear(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementAppear(WebElement element) {
        return waitUntilElementAppear(element, 5);
    }

    public boolean waitUntilElementDisappear(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 1);
    }

    public boolean waitUntilElementDisappear(By by) {
        return waitUntilConditions(by, 15, 1);
    }

    public void waitUntilElementDisappear(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementDisappear(WebElement element) {
        waitUntilElementDisappear(element, 5);
    }

    public static boolean waitUntilElementClickable(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 2);
    }

    public static boolean waitUntilElementClickable(By by) {
        return waitUntilConditions(by, 20, 2);
    }

    public boolean waitUntilElementVisible(By by, int timeInSeconds) {
        return waitUntilConditions(by, timeInSeconds, 3);
    }

    public boolean waitUntilElementVisible(By by) {
        return waitUntilConditions(by, 15, 3);
    }

    public void waitAndAcceptAlertIfPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.picsart.studio:id/dialog_ok_btn"))).click();
            LOGGER.info("Alert was Present and Accepted!");
        } catch (TimeoutException e) {
            LOGGER.info("Alert was not Present!");
        }
    }

    public static void threadSleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
