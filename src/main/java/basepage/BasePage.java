package basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import static java.awt.SystemColor.text;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void visibilityChecker(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void sendTexts(By element, String text){
        visibilityChecker(element);
        driver.findElement(element).sendKeys(text);
    }

    public void clickOn(By element){
        visibilityChecker(element);
        driver.findElement(element).click();
    }

    public Boolean checkElementDisplayed(By element){
        visibilityChecker(element);
        return driver.findElement(element).isDisplayed();
    }
    public void waitForVisibility(By by , int durationIntoSeconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationIntoSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public Boolean assertElementDisplayed(By by){
        waitForVisibility(by,50);
        return  driver.findElement(by).isDisplayed();
    }
    public void scrollToElement(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'})",driver.findElement(element));
    }
    public void elementsValidator(By... elements){
        for (By value : elements) {
            scrollToElement(value);
            Assert.assertTrue(assertElementDisplayed(value));
        }
    }

    public void selectByValueFrmDropdown(String value , By by) {
        Select selectFromDropDown = new Select(driver.findElement(by));
        selectFromDropDown.selectByValue(value);
    }
    public void selectByTextFrmDropdown(String text , By by){
        Select selectFromDropDown = new Select(driver.findElement(by));
        selectFromDropDown.selectByVisibleText(text);
    }

    public void switchToWindowByIndex(int numberOfWindows) {
        String originalWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));  // Adjust the expected number of windows as needed
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(originalWindowHandle);
        String newWindowHandle = windowHandles.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

}
