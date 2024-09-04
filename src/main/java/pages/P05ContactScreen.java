package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
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
    private final By selectedCountry = By.xpath("//div[@class='selected-flag' and @title='India: + 91']");
    private final By phoneNumber_Input = By.xpath("//input[@class='form-control ' and @name ='phoneNumber']");
    private  final By saveCTA = By.xpath("//button[contains(@class, 'MuiButtonBase-root') and .//span[text()='Save'] and .//span[text()='Saving...'] and .//span[text()='Saved']]");
    private final By contactTable = By.xpath("(//*[@data-testid='table-body'])[1]");

    public void elementsValidator(){
        waitForVisibility(contactProfile, 10);
        elementsValidator(contactProfile, title, createContactCTA);
    }

    public void checkAddContact(){
        visibilityChecker(contactProfile);
        clickOn(contactProfile);
        visibilityChecker(title);
//        clickOn(createContactCTA);


    }
    public void createContact(String name, String number){
        visibilityChecker(contactProfile);
//        clickOn(contactProfile);
        clickOn(createContactCTA);
        waitForVisibility(createContactTitle,30);
        sendTexts(name_Input, name);
        clickOn(countryCodeDropdown);
        List<WebElement> getCountryCodeDropdown = driver.findElements(By.xpath("//ul[@class='country-list ']//li"));
        Assert.assertTrue(getCountryCodeDropdown.size() > 0, "Country options should be visible when dropdown is clicked");
        clickOn(dropdownOptionsIndia);
        /*
        Trying to assert the country code also not working Please check it @karim
         */
//        WebElement selectedCountry = driver.findElement(By.xpath("//div[@class='selected-flag' and @title='India: + 91']"));
//        Assert.assertTrue(selectedCountry.getText().contains("+91"), "Selected country code should be India (+91)");
        sendTexts(phoneNumber_Input,number);
        clickOn(saveCTA);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        visibilityChecker(contactTable);

    }



}
