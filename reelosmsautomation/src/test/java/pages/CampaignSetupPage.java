package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignSetupPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    // Locators
    private By titleInput = By.xpath("//input[@placeholder='Enter Title']");
    private By descriptionTextarea = By.xpath("//textarea[@name='subtitle']");
    private By contactInputRow = By.xpath("//div[@class='prefix-value-suffix-row']");
    private By outsideClickArea = By.xpath("//div[contains(@class,'campaign-edit-screens')]");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");
    
    public CampaignSetupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }
    
    public void enterTitle(String titleText) throws InterruptedException {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput));
        js.executeScript("arguments[0].style.border='2px solid blue'", title);
        title.click();
        title.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        title.sendKeys(Keys.DELETE);
        Thread.sleep(300);
        title.sendKeys(titleText);
        System.out.println("✅ Title set successfully!");
    }
    
    public void enterDescription(String descText) {
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextarea));
        js.executeScript("arguments[0].style.border='2px solid green'", description);
        description.click();
        description.clear();
        description.sendKeys(descText);
        System.out.println("✅ Description set successfully!");
    }
    
    public void clickNext() throws InterruptedException {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        js.executeScript("arguments[0].click();", next);
        System.out.println("✅ Clicked on Next button successfully!");
    }
    
    public void handleContactField() throws InterruptedException {
        WebElement contactInput = wait.until(ExpectedConditions.visibilityOfElementLocated(contactInputRow));
        
        try {
            js.executeScript("arguments[0].blur();", contactInput);
        } catch (Exception e) {
            System.out.println("⚠️ Blur failed, clicking outside instead...");
        }
        
        WebElement outsideArea = wait.until(ExpectedConditions.visibilityOfElementLocated(outsideClickArea));
        js.executeScript("arguments[0].click();", outsideArea);
        System.out.println("✅ Clicked outside contact field to remove focus.");
        Thread.sleep(700);
    }
    
    public void clickNextAfterContact() throws InterruptedException {
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
}