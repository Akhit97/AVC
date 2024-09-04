package tests;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02AvocadoWelcomePage;

public class M01AvocadoTest extends BaseTest {
    P01LoginScreen login;
    P02AvocadoWelcomePage home;

    @BeforeClass
    public void initObjects(){
        login = new P01LoginScreen(driver);
        home = new P02AvocadoWelcomePage(driver);
    }
    @Test
    public void loginSuccessToAVC(){
        login.avcLogin("tech@avocad0.dev","tech@123");
        System.out.println("Login Successfully");

        home.checkHomeScreenSuccess();
        System.out.println("HomeScreen Reached Successfully");


    }
//    @Test
//    public void loginWrong(){
//        login.avcLogin("arpit.b@twerlo.com","12345678");
//        System.out.println("Login Again Successfully");
//    }
}
