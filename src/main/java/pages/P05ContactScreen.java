package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class P05ContactScreen extends BasePage {
    public P05ContactScreen(WebDriver driver) {
        super(driver);
    }
    private final By contactProfile = By.xpath("//button[@aria-label='Contacts']");
    private final By title = By.xpath("//*[normalize-space() = 'Contacts']");
    private final By createContactCTA = By.xpath("//*[@data-testid='create-contact-button']");
    private final By createContactTitle = By.xpath("(//*[normalize-space() = 'Create new contact'])[2]");
    private final By name_Input = By.xpath("(//*[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[1]");
    private final By countryCodeDropdown = By.xpath("//div[@class='selected-flag']");
//    private final By getCountryCodeDropdown = By.xpath("//ul[@class='country-list ']//li");
    private final By dropdownOptionsIndia = By.xpath("//ul[@class='country-list ']/li[@data-country-code='in']");
//    private final By selectedCountry = By.xpath("//div[@class='selected-flag' and @title='India: + 91']");
    private final By phoneNumber_Input = By.xpath("//input[@class='form-control ' and @name ='phoneNumber']");
    private  final By saveCTA = By.xpath("//button[contains(@class, 'MuiButtonBase-root') and .//span[text()='Save'] and .//span[text()='Saving...'] and .//span[text()='Saved']]");
    private final By contactTable = By.xpath("(//*[@data-testid='table-body'])[1]");
    private final By uploadCTA = By.xpath("//*[@data-testid='create-contact-upload-image']");
    private final By upload = By.xpath("//*[@type= 'file']");

//    private final By channelFilterDropdown = By.xpath("(//*[@type='button' and @aria-label='Open'])[1]");
    private final By channelInput = By.xpath("(//input[contains(@class, 'MuiInputBase-input' )])[1]");
    private final By searchFilterCTA = By.xpath("(//button[@data-testid='apply-filter-search-button'])[1]");
    private final By updateTable = By.xpath("(//*[@data-testid='table' and @aria-label='simple table'])[1]");

    public void elementsValidator(){
        waitForVisibility(contactProfile, 10);
        elementsValidator(contactProfile, title, createContactCTA);
    }

    String currentDir = System.getProperty("user.dir");
    String file_path = currentDir + "//image//image2.jpeg";

    public void checkAddContact(){
        visibilityChecker(contactProfile);
        clickOn(contactProfile);
        visibilityChecker(title);
//        clickOn(createContactCTA);


    }
    public void createContact(String name, String number) throws InterruptedException {
        visibilityChecker(contactProfile);
//        clickOn(contactProfile);
        clickOn(createContactCTA);
        waitForVisibility(createContactTitle,30);
        sendTexts(name_Input, name);
        clickOn(countryCodeDropdown);
        List<WebElement> getCountryCodeDropdown = driver.findElements(By.xpath("//ul[@class='country-list ']//li"));
        Assert.assertTrue(getCountryCodeDropdown.size() > 0, "Country options should be visible when dropdown is clicked");
        clickOn(dropdownOptionsIndia);

        By selectedCountry = By.xpath("//*[@class='selected-flag' and @title='India: + 91']");
        waitForVisibility(selectedCountry,10);
        System.out.println("test" + driver.findElement(selectedCountry).getText());

//        Assert.assertTrue(driver.findElement(selectedCountry).getText().contains("+ 91"), "Selected country code should be India (+91)");
        sendTexts(phoneNumber_Input,number);

        driver.findElement(upload).sendKeys(file_path);
        waitForVisibility(uploadCTA, 10);

        clickOn(saveCTA);
        Thread.sleep(10000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        visibilityChecker(contactTable);

    }

//    public void channelFilter(String text){
//        waitForVisibility(channelFilterDropdown,10);

//        WebElement channelDropdown = driver.findElement(By.xpath("//*[@type='button' and @aria-label='Open'])[1]"));

//        List<WebElement> channelDropdown = driver.findElements(By.xpath("//button[@type='button' and @aria-label='Open'])[1]"));
        // Create a Select object for the dropdown
//        Select sel = new Select((WebElement) channelDropdown);
//        List<WebElement> options = select.getOptions();
//        for (WebElement option : options) {
//            // Select each option by visible text
//            String optionText = option.getText();
//            select.selectByVisibleText(optionText);
//            waitForVisibility(updateTable, 20);
//        }

    public void channelFilter(String text) throws InterruptedException {
        sendTexts(channelInput,text);
        driver.findElement(channelInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(channelInput).sendKeys(Keys.ENTER);
        clickOn(searchFilterCTA);
//        waitForVisibility(updateTable, 30);
        List<WebElement> updateTable = driver.findElements(By.xpath("(//tbody[@data-testid='table-body'])[1]"));
        Thread.sleep(10000);
        for (WebElement row : updateTable) {
            WebElement channelIcon = driver.findElement(By.xpath("(//*[@data-testid='platform-icon'])[1]"));
            String channelText = channelIcon.getText();

            if (!channelText.contains(text)) {
                System.out.println("Test Failed: Row channel does not match selected filter.");
            } else {
                System.out.println("Test Passed: " + text + " filter is applied correctly.");
            }
        }

    }



}
