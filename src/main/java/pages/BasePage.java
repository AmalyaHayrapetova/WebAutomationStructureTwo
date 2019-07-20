package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;

import java.util.List;

public class BasePage {

    static protected WebDriver driver;
    private WebDriverWait wait;
    private WaitUtils waitUtils;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        waitUtils = new WaitUtils(driver);


    }


    protected void click(By by) {
        waitUtils.waitUntilElementAppear(by);
        driver.findElement(by).click();
    }

    protected boolean isElementPresent(By by) {
//        waitVisibility(by);
        List<WebElement> elementLis = driver.findElements(by);

        if (elementLis.size() > 0)
            return true;
        else
            return false;


    }

    protected void open(String url) {
        driver.get(url);
    }

    protected void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    protected void type(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    protected String getText(By by) {
//        waitUtils.waitUntilElementAppear(by);
        return driver.findElement(by).getText();
    }

//    /**
//     * Get element's orientation.
//     *
//     * @param view
//     * @param viewIndex
//     * @return HORIZONTAL or VERTICAL
//     */
//    public List<Object> getOrientation(By view, int viewIndex) {
//        List<Object> temp = new LinkedList<>();
//
//
//        List<MobileElement> scrollView = driver.findElements(view);
//        temp.add(scrollView.get(viewIndex));
//        int x = scrollView.get(viewIndex).getSize().getWidth();
//        int y = scrollView.get(viewIndex).getSize().getHeight();
//        if (x != y) {
//            if (x > y) {
//                temp.add(orientation.HORIZONTAL);
//            } else {
//                temp.add(orientation.VERTICAL);
//            }
//        }
//        return temp;
//    }
//
//
//    /**
//     * Swipe until finding the element.
//     * Element of String type
//     *
//     * @param scrollable
//     * @param name
//     * @param percent
//     * @param direction
//     */
//
//    public void autoSearch(WebElement scrollable, String name, int percent, Object direction) {
//
//        int x_ = scrollable.getLocation().getX() + scrollable.getSize().getWidth() / 2;
//        int y_ = scrollable.getLocation().getY() + scrollable.getSize().getHeight() / 2;
//        int y_1 = (y_ * percent) / 100;
//        int x_h = (x_ * percent) / 100;
//
//        int maxSwipeCount = 40;
//        Orientation temp = ((Orientation) direction);
//        switch (temp) {
//            case VERTICAL:
//                while (!isTextPresent(name) && maxSwipeCount != 0) {
//                    swipeByCoordinate(x_, y_, x_, y_1, 1500);
//                    maxSwipeCount--;
//                }
//                break;
//
//            case HORIZONTAL:
//                while (!isTextPresent(name) && maxSwipeCount != 0) {
//                    swipeByCoordinate(x_, y_, x_h, y_, 1500);
//                    maxSwipeCount--;
//
//                }
//                break;
//
//
//            default:
//                LOGGER.info("The direction is missing!");
//        }
//
//    }
//

    public void clickOnText(By by, String name) {
        List<WebElement> elements = driver.findElements(by);
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(name))
                index = i;
            break;
        }

        elements.get(index).click();
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        WaitUtils.threadSleep(3000);
    }

    protected void switchFrames(By by) {
        WebElement element = driver.findElement(by);
        driver.switchTo().frame(element);
    }

}

