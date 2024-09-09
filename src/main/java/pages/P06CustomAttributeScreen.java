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
    private final By backCTA = By.xpath("//button[@data-testid='back-button']");
    private final By customMainPage = By.xpath("//p[normalize-space() = 'Custom Attributes']");
    private final By descriptionMainPage = By.xpath("//p[@data-testid='description']");
    private final By pageDetails = By.xpath("//p[@data-testid='page-details']");
    private final By pagination = By.xpath("//nav[@aria-label='pagination navigation']");
    private final By addNew_Custom = By.xpath("//button[@data-testid='button-add-new-custom-attribute']");
    private final  By name_Input = By.xpath("//*[@aria-label='custom-attribute-name']");
    private final By description_Input = By.xpath("(//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-u36398'])[1]");
    private final By type_Dropdown = By.xpath("//*[@data-testid='select-options-button']]");
    private final By getType_Dropdown = By.xpath("//*[@class ='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-1uvydh2']");
    private final By saveCustomCTA = By.xpath("//button[.//span[contains(text(),'Add Custom Attribute')] and .//span[text() = 'Adding Custom Attribute...'] and .//span[text() = 'Custom Attribute added']]");
    private final By search_Input = By.xpath("//input[@placeholder = 'Search Attributes']");
    private final By attributeTable = By.xpath("//div[@class = 'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 MuiGrid-spacing-sm-2 MuiGrid-spacing-md-3 css-1439mu1']");
    private final By actionEllipsis = By.xpath("(//button[@data-testid='actions-button'])[1]");
    private final By editCTA = By.xpath("//button[@data-testid='undefined-0']");
    private final By edit_Title = By.xpath("//p[normalize-space()='Edit Custom Attribute']");
    private final By edit_Input = By.xpath("//*[@aria-label='custom-attribute-name']");
    private final By updateCTA = By.xpath("//button[.//span[contains(text(),'Update')] and .//span[text() = 'Updating...'] and .//span[text() = 'Updated']]");
    private final By deleteCTA =By.xpath("//button[@data-testid='undefined-1']");
    private final By delete_Title = By.xpath("//p[@data-testid='delete-confirm-title']");
    private final By data_deletedCTA = By.xpath("//button[@data-testid='deleted-modal-deleted-btn']");
    private final By delete_CancelCTA = By.xpath("//button[@data-testid='deleted-modal-cancel-btn']");



    public void addNewCustomAttribute(String name,String description, String type) throws InterruptedException {
        visibilityChecker(appCTA);
        clickOn(appCTA);
        clickOn(customCTA);
//        waitForVisibility(customMainPage,50);
        checkElementDisplayed(customMainPage);
        assertElementDisplayed(descriptionMainPage);
        scrollToElement(pageDetails);
        assertElementDisplayed(pageDetails);
        assertElementDisplayed(pagination);

        clickOn(addNew_Custom);
        sendTexts(name_Input, name);
        sendTexts(description_Input, description);
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
//        visibilityChecker(appCTA);
//        clickOn(appCTA);
//        clickOn(customCTA);
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

    }
    public void editAttribute(String edit) throws InterruptedException {
        clickOn(actionEllipsis);
        clickOn(editCTA);
        System.out.println("edit attribute page open");
        waitForVisibility(edit_Title,30);
        clickOn(edit_Input);
        driver.findElement(edit_Input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(edit_Input).sendKeys(Keys.DELETE);
        sendTexts(edit_Input, edit);
        clickOn(updateCTA);
        System.out.println("attribute updated");
        Thread.sleep(10000);

    }
    public void deleteAttribute() throws InterruptedException {

        clickOn(actionEllipsis);
        clickOn(deleteCTA);
        waitForVisibility(delete_Title,30);
        System.out.println("Delete page opne");
        clickOn(delete_CancelCTA);
        System.out.println("Cancel data delete");
        Thread.sleep(5000);
        clickOn(actionEllipsis);
        clickOn(deleteCTA);
        waitForVisibility(delete_Title,40);
        clickOn(data_deletedCTA);
        Thread.sleep(5000);
        System.out.println("Data deleted");
        clickOn(backCTA);
        Thread.sleep(10000);

    }

}


