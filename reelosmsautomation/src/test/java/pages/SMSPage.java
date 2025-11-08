package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SMSPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    // Locators
    private By editableFields = By.xpath("//div[@class='textarea']//*[self::input or @contenteditable='true']");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");
    private By testCampaignBtn = By.xpath("//span[normalize-space()='Test campaign']");
    private By saveAndExitBtn = By.xpath("//button[normalize-space()='Save and exit']");
    
    public SMSPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }
    
    public void fillSMSTextFields() throws InterruptedException {
        try {
            List<WebElement> fields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(editableFields));
            System.out.println("Found " + fields.size() + " editable fields.");
            
            String[] promoText = {
                "CheesyBite",
                "By Atul!",
                "NachoTime",
                "TastyWay!",
                "AtulCorner",
                "SnackJoy!",
                "CheeseHub",
                "YumTreats",
                "JoinToday!",
                "FeelCheesy"
            };
            
            int count = 0;
            for (WebElement field : fields) {
                js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", field);
                Thread.sleep(400);
                
                // Clear old text
                if (field.getTagName().equalsIgnoreCase("input")) {
                    field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                } else {
                    js.executeScript("arguments[0].innerText = '';", field);
                }
                
                // Insert new campaign text
                String textToEnter = promoText[count % promoText.length];
                field.sendKeys(textToEnter);
                System.out.println("✅ Field " + (count + 1) + " set to: " + textToEnter);
                
                count++;
                Thread.sleep(300);
            }
            
            System.out.println("🎯 All SMS text fields updated with catchy campaign phrases!");
            
        } catch (Exception e) {
            System.out.println("❌ Failed to update SMS fields: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickNext() throws InterruptedException {
        try {
            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", next);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", next);
            System.out.println("✅ Clicked on Next button successfully!");
            
        } catch (Exception e) {
            System.out.println("❌ Failed to click Next button: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickTestCampaign() throws InterruptedException {
        try {
            WebElement testBtn = wait.until(ExpectedConditions.elementToBeClickable(testCampaignBtn));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", testBtn);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", testBtn);
            System.out.println("✅ Test campaign sent successfully");
            Thread.sleep(6000);
            
        } catch (Exception e) {
            System.out.println("❌ Failed to send test campaign: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickSaveAndExit() throws InterruptedException {
        try {
            WebElement saveExit = wait.until(ExpectedConditions.elementToBeClickable(saveAndExitBtn));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", saveExit);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", saveExit);
            System.out.println("✅ Save and exit successful");
            Thread.sleep(5000);
            
        } catch (Exception e) {
            System.out.println("❌ Failed to save and exit: " + e.getMessage());
            throw e;
        }
    }
}