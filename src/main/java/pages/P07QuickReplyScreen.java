package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class P07QuickReplyScreen extends BasePage {
    public P07QuickReplyScreen(WebDriver driver) {
        super(driver);
    }
    private final By appCTA = By.xpath("//button[@aria-label='Apps' and @value='Apps']");
    private final By quickCTA = By.xpath("//a[@href='/apps/quick-reply']");
    private final By backTo_App = By.xpath("//button[@data-testid='back-button']");
    private final By mainTitle = By.xpath("//p[normalize-space() = 'Quick Replies']");
    private final By mainDescription = By.xpath("//p[@data-testid='description']");
    private final By add_QuickButton = By.xpath("//button[@data-testid= 'add-new-quick-reply-button']");
    private final By create_QuickTitle = By.xpath("//p[normalize-space() = 'Create New Quick Reply']");
    private final By create_QuickCloseCTA = By.xpath("//button[@data-testid='add-new-quick-reply-close-button']");
    private final By create_ShortInput = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']");
    private final By create_Keyword = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused css-1x5jdmq']");
    private final By create_Body = By.xpath("(//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-u36398'])[1]");
    private final By create_AvailableTo = By.xpath("//*[@data-testid='select-available-to']");
    private final By create_AttachmentCTA = By.xpath("//button[@data-testid='select-attach-file-button']");
    private final By create_Upload = By.xpath("//*[@type= 'file']");
    private final By upload_Select = By.xpath("//button[@data-testid='select-attach-file-save-button']");

    private final By create_CancelCTA = By.xpath("//button[@data-testid='create-quick-reply-cancel-button']");
    private final By create_SaveCTA = By.xpath("//button[.//span[contains(text(),'Save')] and .//span[text() = 'Saving...'] and .//span[text() = 'Saved']]");
    private final By search_Input = By.xpath("//input[@placeholder = 'Search']");
    private final By filter = By.xpath("//input[@placeholder='All types of Quick Replies']");
    private final By action_Elipsis = By.xpath("(//button[@data-testid='actions-button'])[1]");
    private final By editCTA = By.xpath("//button[@data-testid='undefined-0']");
    private final By edit_Title = By.xpath("//p[normalize-space() ='Edit Quick Reply']");
    private final By editCloseCTA = By.xpath("//button[@data-testid='add-new-quick-reply-close-button']");
    private final By edit_ShortInput = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']");
    private final By edit_Keyword =By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-1ixds2g']");
    private final By edit_CancelCTA = By.xpath("//button[@data-testid='create-quick-reply-cancel-button']");
    private final By edit_UpdateCTA = By.xpath("//button[.//span[contains(text(),'Update')] and .//span[text() = 'Updating...'] and .//span[text() = 'Updated']]");
    private final By delete_CTA = By.xpath("//button[@data-testid='undefined-1']");
    private final By delete_Title = By.xpath("//p[@data-testid='delete-confirm-title']");
    private final By delete_DataCTA = By.xpath("//button[@data-testid='deleted-modal-deleted-btn']");

    String currentDirr = System.getProperty("user.dir");
    String file_path = currentDirr + "//image//image2.jpeg";

    public void addNewQuickReplyClosebtn() throws InterruptedException {
        visibilityChecker(appCTA);
        clickOn(appCTA);
        clickOn(quickCTA);
        checkElementDisplayed(backTo_App);
        clickOn(backTo_App);
        clickOn(quickCTA);
        checkElementDisplayed(mainTitle);
        checkElementDisplayed(mainDescription);
        clickOn(add_QuickButton);
        waitForVisibility(create_QuickTitle,50);
        clickOn(create_QuickCloseCTA);
        Thread.sleep(10000);
    }
    public void addQuickReplyWithCancelButton(String text, String keyword, String body) throws InterruptedException {
        clickOn(add_QuickButton);
        checkElementDisplayed(create_QuickTitle);
        sendTexts(create_ShortInput, text);
        sendTexts(create_Keyword, keyword);
        sendTexts(create_Body, body);
        clickOn(create_AvailableTo);
        Actions action = new Actions(driver);
        action.pause(Duration.ofSeconds(10)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOn(create_CancelCTA);
        Thread.sleep(10000);
    }
    public void addQuickReplyWithSavedButton(String text, String keyword, String body) throws InterruptedException {
        clickOn(add_QuickButton);
        checkElementDisplayed(create_QuickTitle);
        sendTexts(create_ShortInput, text);
        sendTexts(create_Keyword, keyword);
        sendTexts(create_Body, body);
//        clickOn(create_AttachmentCTA);
//        driver.findElement(create_Upload).sendKeys(file_path);
        clickOn(create_AvailableTo);
        Actions action = new Actions(driver);
        action.pause(Duration.ofSeconds(10)).sendKeys(Keys.ENTER).perform();
        clickOn(create_AttachmentCTA);
        driver.findElement(create_Upload).sendKeys(file_path);
        action.pause(Duration.ofSeconds(10)).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        clickOn(upload_Select);
        clickOn(create_SaveCTA);
        Thread.sleep(10000);
    }
    public void searchData(String text) throws InterruptedException {
        clickOn(search_Input);
        sendTexts(search_Input, text);
        Thread.sleep(5000);
        driver.findElement(search_Input).sendKeys(Keys.CONTROL + "a");
        driver.findElement(search_Input).sendKeys(Keys.DELETE);
        Thread.sleep(5000);
    }
    public void filterData(String text) throws InterruptedException {
        clickOn(filter);
        sendTexts(filter, text);
        driver.findElement(filter).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(filter).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(filter).sendKeys(Keys.CONTROL + "a");
        driver.findElement(filter).sendKeys(Keys.DELETE);
        Thread.sleep(5000);
    }

    public void editPageClose(){
        clickOn(action_Elipsis);
        clickOn(editCTA);
        waitForVisibility(edit_Title,50);
        clickOn(editCloseCTA);
    }

    public void editPageCancel(String text, String word) throws InterruptedException {
        clickOn(action_Elipsis);
        clickOn(editCTA);
        Thread.sleep(3000);
        waitForVisibility(edit_Title,50);
        sendTexts(edit_ShortInput, text);
        sendTexts(edit_Keyword, word);
        clickOn(edit_CancelCTA);
        Thread.sleep(5000);
    }
    public void editPageUpdate(String text, String word) throws InterruptedException {
        clickOn(action_Elipsis);
        clickOn(editCTA);
        Thread.sleep(3000);
        waitForVisibility(edit_Title,30);
        clickOn(edit_ShortInput);
        driver.findElement(edit_ShortInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(edit_ShortInput).sendKeys(Keys.DELETE);
        sendTexts(edit_ShortInput, text);

        sendTexts(edit_Keyword, word);
        clickOn(edit_UpdateCTA);
        Thread.sleep(5000);
    }
    public void dataDeleted() throws InterruptedException {
        clickOn(action_Elipsis);
        clickOn(delete_CTA);
        waitForVisibility(delete_Title, 30);
        clickOn(delete_DataCTA);
        Thread.sleep(5000);
    }
}
