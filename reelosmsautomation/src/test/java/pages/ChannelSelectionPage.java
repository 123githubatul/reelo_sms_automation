package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChannelSelectionPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    // Locators
    private By allChannels = By.xpath("//div[contains(@class,'channel')]");
    private By selectedChannels = By.xpath("//div[contains(@class,'channel channel-selected')]");
    private By smsChannelXPath = By.xpath("//div[contains(@class,'channel')]//*[contains(translate(text(),'sms','SMS'),'SMS')]/ancestor::div[contains(@class,'channel')]");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");
    
    public ChannelSelectionPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }
    
    public void ensureOnlySMSSelected() throws InterruptedException {
        try {
            // Wait for channels to load
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allChannels));
            
            // Deselect all selected channels except SMS
            List<WebElement> selected = driver.findElements(selectedChannels);
            for (WebElement channel : selected) {
                String label = channel.getText();
                if (!label.toLowerCase().contains("sms")) {
                    js.executeScript("arguments[0].click();", channel);
                    Thread.sleep(400);
                }
            }
            
            // Locate and select SMS channel if not already selected
            WebElement smsChannel = driver.findElement(smsChannelXPath);
            js.executeScript("arguments[0].scrollIntoView(true);", smsChannel);
            Thread.sleep(400);
            
            String smsClass = smsChannel.getAttribute("class");
            if (!smsClass.contains("channel-selected")) {
                js.executeScript("arguments[0].click();", smsChannel);
                System.out.println("✅ SMS channel selected successfully!");
            } else {
                System.out.println("✅ SMS channel was already selected — no change made.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Failed to ensure only SMS is selected: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickNext() {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        js.executeScript("arguments[0].click();", next);
        System.out.println("✅ Clicked on Next button successfully!");
    }
}