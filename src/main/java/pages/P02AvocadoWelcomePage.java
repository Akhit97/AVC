package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P02AvocadoWelcomePage extends BasePage {
    public P02AvocadoWelcomePage(WebDriver driver) {
        super(driver);
    }
    private final By viewAs_from_home = By.xpath("//*[@data-testid='view-as-txt']");
    private final By profileCta = By.xpath("//button[@aria-label='Profile']");
    private final By admin_Text = By.xpath("//*[@class = 'MuiTypography-root MuiTypography-body1 css-yygrb0']");
    private final By logoutCTA = By.xpath("//*[@data-testid='logout-button']");
    private final By unAssignedBtn = By.xpath("(//*[@type='button'])[20]");
    private final By signIntoLabel = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-6f19s']");

    public void checkHomeScreenSuccess(){
        visibilityChecker(viewAs_from_home);
//        clickOn(profileCta);
//        visibilityChecker(admin_Text);
//        clickOn(logoutCTA);
//        visibilityChecker(signIntoLabel);
//        Assert.assertEquals("Unassigned", driver.findElement(unAssignedBtn).getText(),"can't find element");
    }
}
