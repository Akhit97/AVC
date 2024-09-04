package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.app.avocad0.dev/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void openingChrome(){
        System.out.println("Driver is openning");
    }
    @AfterClass
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }

}
