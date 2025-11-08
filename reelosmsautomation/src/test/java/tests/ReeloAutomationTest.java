package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class ReeloAutomationTest extends BaseTest {
    
    @Test
    public void smsCampaignTest() throws InterruptedException {
        
        // Initialize Page Objects
        LoginPage loginPage = new LoginPage(driver, wait);
        CampaignPage campaignPage = new CampaignPage(driver, wait, js);
        ChannelSelectionPage channelPage = new ChannelSelectionPage(driver, wait, js);
        CampaignSetupPage setupPage = new CampaignSetupPage(driver, wait, js);
        CreativePage creativePage = new CreativePage(driver, wait, js);
        SMSPage smsPage = new SMSPage(driver, wait, js);
        
        // Step 1: Login
        loginPage.login("atulprajapathi@gmail.com", "Outlook@123");
        
        // Step 2: Navigate to Campaign
        campaignPage.clickCampaignMenu();
        campaignPage.selectNachoTemplate();
        campaignPage.selectSMSChannel();
        campaignPage.clickCustomizeAndSend();
        
        // Step 3: Select SMS Channel
        channelPage.ensureOnlySMSSelected();
        channelPage.clickNext();
        
        // Step 4: Campaign Setup - Title & Description
        setupPage.enterTitle("atul");
        setupPage.enterDescription("This is for testing purpose");
        setupPage.clickNext();
        
        // Step 5: Handle Contact Field
        setupPage.handleContactField();
        setupPage.clickNextAfterContact();
        
        // Step 6: Upload Logo
        creativePage.uploadLogo("C:\\Users\\Admin\\eclipse-workspace\\reelosmsautomation\\src\\test\\resources\\logo.jpg");
        creativePage.saveLogo();
        creativePage.clickNext();
        
        // Step 7: Fill SMS Text Fields
        smsPage.fillSMSTextFields();
        smsPage.clickNext();
        
        // Step 8: Test & Save Campaign
        smsPage.clickTestCampaign();
        smsPage.clickSaveAndExit();
        
        System.out.println("🎉 SMS Campaign Automation Completed Successfully!");
    }
}