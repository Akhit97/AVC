package tests;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02AvocadoWelcomePage;
import pages.P07QuickReplyScreen;

public class M04QuickReplyTest extends BaseTest {
    P01LoginScreen login;
    P02AvocadoWelcomePage home;
    P07QuickReplyScreen quick;

    @BeforeClass
    public void initObjects(){
        login = new P01LoginScreen(driver);
        home = new P02AvocadoWelcomePage(driver);
        quick = new P07QuickReplyScreen(driver);
    }
    @Test
    public void checkQuickReply() throws InterruptedException {
        login.avcLogin("arpit.b@twerlo.com","12345678");
        home.checkHomeScreenSuccess();
        quick.addNewQuickReplyClosebtn();
        quick.addQuickReplyWithCancelButton("testing", "test","atoz");
        quick.addQuickReplyWithSavedButton("tester","best8","better8");
        quick.searchData("89");
        quick.filterData("tex");
        quick.filterData("doc");
        quick.filterData("ima");
        quick.editPageClose();
//        quick.editPageCancel("zzzzv","ui");
//        quick.editPageUpdate("uuuuu","yyy");
        quick.dataDeleted();
    }
}
