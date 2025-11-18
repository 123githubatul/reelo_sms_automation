package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    // Locators
    private By campaignMenu = By.xpath("//span[contains(@class,'menu-title') and normalize-space()='Campaigns']");
    private By nachoTemplate = By.xpath("//body/div[@id='root']/div[@class='app-and-sidebar-layout app-and-sidebar-layout--alert-banner-hidden']/div[@class='private-layout-root']/main[@class='main-content ']/div[@class='campaigns-homepage']/div[@class='categories']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]");
    private By smsChannel = By.xpath("//div[normalize-space()='SMS']");
    private By customizeSendBtn = By.xpath("//span[normalize-space()='Customise and Send']");
    
    public CampaignPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }
    
    public void clickCampaignMenu() throws InterruptedException {
        WebElement campaign = wait.until(ExpectedConditions.elementToBeClickable(campaignMenu));
        js.executeScript("arguments[0].click();", campaign);
        Thread.sleep(1000);
    }
    
    public void selectNachoTemplate() throws InterruptedException {
        WebElement template = wait.until(ExpectedConditions.visibilityOfElementLocated(nachoTemplate));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", template);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", template);
        
        
    	
    }
    
    public void selectSMSChannel() throws InterruptedException {
        WebElement sms = wait.until(ExpectedConditions.visibilityOfElementLocated(smsChannel));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sms);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", sms);
        Thread.sleep(3000);
    }
    
    public void clickCustomizeAndSend() throws InterruptedException {
        WebElement customizeBtn = wait.until(ExpectedConditions.elementToBeClickable(customizeSendBtn));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", customizeBtn);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", customizeBtn);
        System.out.println("✅ Clicked on 'Customize and Send' successfully!");
    }

}
