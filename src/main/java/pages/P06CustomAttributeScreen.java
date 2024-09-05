package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;

public class P06CustomAttributeScreen extends BasePage {
    public P06CustomAttributeScreen(WebDriver driver) {
        super(driver);
    }
    private final By appCTA = By.xpath("//button[@aria-label='Apps' and @value='Apps']");
    private final By customCTA = By.xpath("//*[@href='/apps/custom-attributes']");
    private final By addNew_Custom = By.xpath("//button[@data-testid='button-add-new-custom-attribute']");
    private final  By name_Input = By.xpath("//*[@aria-label='custom-attribute-name']");
    private final By description_Input = By.xpath("(//textarea[@id=':r2o:']");
    private final By type_Dropdown = By.xpath("//*[@data-testid='select-options-button']]");
    private final By getType_Dropdown = By.xpath("//*[@class ='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-1uvydh2']");
    private final By saveCustomCTA = By.xpath("//button[.//span[contains(text(),'Add Custom Attribute')] and .//span[text() = 'Adding Custom Attribute...'] and .//span[text() = 'Custom Attribute added']]");
    private final By search_Input = By.xpath("//input[@placeholder = 'Search Attributes']");
    private final By attributeTable = By.xpath("//div[@class = 'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 MuiGrid-spacing-sm-2 MuiGrid-spacing-md-3 css-1439mu1']");
    private final By actionEllipsis = By.xpath("(//button[@data-testid='actions-button'])[1]");



    public void addNewCustomAttribute(String name, String type) throws InterruptedException {
        visibilityChecker(appCTA);
        clickOn(appCTA);
        clickOn(customCTA);
        clickOn(addNew_Custom);
        sendTexts(name_Input, name);
//        sendTexts(description_Input, description);
//        scrollToElement(type_Dropdown);
        scrollToElement(getType_Dropdown);
        clickOn(getType_Dropdown);
        sendTexts(getType_Dropdown, type);

        driver.findElement(getType_Dropdown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(getType_Dropdown).sendKeys(Keys.ENTER);
//        visibilityChecker(getType_Dropdown);
        clickOn(saveCustomCTA);
        Thread.sleep(10000);
        waitForVisibility(attributeTable,10);


//        By validateMsg = By.xpath("//*[normalize-space() = 'Name already taken']");
//        waitForVisibility(validateMsg,10);
//        System.out.println(driver.findElement(validateMsg).getText());

//        Assert.assertTrue(driver.findElement(validateMsg).getText().contains("Name already taken"), "Name already taken");


    }

    public void searchAttribute(String input) throws InterruptedException {
        visibilityChecker(appCTA);
        clickOn(appCTA);
        clickOn(customCTA);
        clickOn(search_Input);
        sendTexts(search_Input, input);
        Thread.sleep(5000);
        System.out.println("Searched Data");
//        clickOn(search_Input);
//        driver.findElement(search_Input).clear();
        driver.findElement(search_Input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(search_Input).sendKeys(Keys.DELETE);
        Thread.sleep(10000);
        System.out.println("Search field is cleared");
        clickOn(actionEllipsis);


    }

}


