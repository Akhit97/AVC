package tests;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02AvocadoWelcomePage;
import pages.P06CustomAttributeScreen;

public class M03CustomAttributeTest extends BaseTest {
    P01LoginScreen login;
    P02AvocadoWelcomePage home;
    P06CustomAttributeScreen custom;

    @BeforeClass
    public void initObjects(){
        login = new P01LoginScreen(driver);
        home = new P02AvocadoWelcomePage(driver);
        custom = new P06CustomAttributeScreen(driver);
    }
    @Test
    public void attributeAdded() throws InterruptedException {
        login.avcLogin("arpit.b@twerlo.com","12345678");
        System.out.println("login Success");
        home.checkHomeScreenSuccess();
        System.out.println("Reached Home");
        custom.addNewCustomAttribute("Testing9029","testing","Url");
        System.out.println("new attribute page open");
        custom.searchAttribute("has");
        System.out.println("Data is Searched");
        custom.editAttribute("Happy");
        custom.deleteAttribute();
    }
}
