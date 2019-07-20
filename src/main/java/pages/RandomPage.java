package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class RandomPage extends BasePage {

    public RandomPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Generate random numbers which length is given count
     */

    public static int generateRandomNumbers(int count) {
        return Integer.parseInt(RandomStringUtils.random(count, false, true));
    }

    /**
     * Generate random letters with current count
     *
     * @param count
     * @return
     */
    public static String generateRandomLetters(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }


    /**
     * Generate random letters and numbers with current count
     *
     * @param count
     * @return
     */
    public static String generateRandomLettersAndNumbers(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    /**
     * Switch frame to default content
     */
    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}
