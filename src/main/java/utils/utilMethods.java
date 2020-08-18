package utils;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public class utilMethods {

    public static void selectByValue(WebDriver driver, WebElement matSelect, String expectedString) {
        for (WebElement element : getSelectList(driver, matSelect)) {
            String text = element.findElement(By.xpath("./span")).getText();
            if (text.contains(expectedString)) {
                element.click();
                break;
            }
        }
    }

    public static void selectByIndex(WebDriver driver, WebElement matSelect, int expectedValue) {
        getSelectList(driver, matSelect).get(expectedValue).click();
    }

    private static List<WebElement> getSelectList(WebDriver driver, WebElement matSelect) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until((t) -> matSelect.isEnabled());
        matSelect.click();
        List<WebElement> listSelect = driver.findElements(By.xpath("//mat-option[not(contains(@class, \"select-search\"))]"));
        wait.until((t) -> !listSelect.get(0).getText().trim().isEmpty());
        return listSelect;
    }

    public static void scrollTo(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static Function<WebDriver, Boolean> multyClick(WebElement element) {
        return driver -> {
            for (int i = 0; i < 200; i++) {
                try {
                    Thread.sleep(100);
                    element.click();
                    return true;
                } catch (Exception ignored) {}
            }
            return false;
        };
    }

    public static void tabAndChooseUntilFocus(WebDriver driver, WebElement element) {
        int count = 0;
        while (!element.getAttribute("class").contains("focused")) {
            if (100 < count) {
                throw new TimeoutException("Cannot go to the next step");
            }
            new Actions(driver).sendKeys(Keys.TAB).sendKeys(Keys.DOWN).perform();
            count++;
        }
    }

}
