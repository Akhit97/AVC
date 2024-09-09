package tests;

import basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02AvocadoWelcomePage;
import pages.P05ContactScreen;

import java.time.Duration;

public class M02ContactTest extends BaseTest {
    P01LoginScreen login;
    P02AvocadoWelcomePage home;
    P05ContactScreen contact;

    @BeforeClass
    public void initObjects(){
        login = new P01LoginScreen(driver);
        home = new P02AvocadoWelcomePage(driver);
        contact = new P05ContactScreen(driver);
    }

    @Test
    public void checkingContactCreationSuccess() throws InterruptedException {
        login.avcLogin("arpit.b@twerlo.com", "12345678");
        System.out.println("Login Succeed :)");
        home.checkHomeScreenSuccess();
        System.out.println("Reached Home Screen (: !! :)");
        contact.checkAddContact();
        System.out.println("Reached Contact Screen");
        contact.createContact("aaaaa236", "8867760906");
        contact.channelFilter("what");

        System.out.println("Added Contact");

    }
}
