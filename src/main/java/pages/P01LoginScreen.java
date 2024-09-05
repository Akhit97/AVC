package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class P01LoginScreen extends BasePage {
    public P01LoginScreen(WebDriver driver) {
        super(driver);
    }
    private final By logo = By.xpath("//*[@src='https://assets.avocad0.dev/sdk/mottasl_blue.png']");
    private final By mottaslLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1kq6k1d']");
    private final By signIntoLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s']");
    private final By twerloLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-u9tiro']");
    private final By email_Input = By.id(":r0:");
    private final By password_Input = By.id(":r1:");
    private final By eye_button = By.xpath("(//*[@data-testid='VisibilityIcon'])[2]");
    private final By workSpace = By.xpath("//input[contains(@class, 'MuiAutocomplete-input')]");
    private final By loginCTA = By.xpath("(//button[@type='button'][normalize-space()='Login'])[2]");
    private final By viewAs_from_home = By.xpath("//*[@data-testid='view-as-txt']");

    public void elementsValidateLocator(){
        waitForVisibility(logo,20);
        elementsValidator(logo, mottaslLabel, signIntoLabel, twerloLabel, email_Input, password_Input,eye_button, workSpace, loginCTA);


    }
    public void avcLogin(String email, String password){
        visibilityChecker(logo);
        sendTexts(email_Input, email);
        sendTexts(password_Input, password);
        clickOn(password_Input);
//        clickOn(eye_button);
        clickOn(workSpace);
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(5)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        clickOn(loginCTA);
        visibilityChecker(viewAs_from_home);

    }


    
}
