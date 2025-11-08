package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreativePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    // Locators
    private By uploadLabel = By.xpath("//label[@for='logo-upload']");
    private By fileInput = By.id("logo-upload");
    private By saveButton = By.xpath("//button[@class='sb-button sb-button--sm sb-button--full-width sb-button--primary']");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");
    
    public CreativePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }
    
    public void uploadLogo(String filePath) throws InterruptedException {
        try {
            WebElement uploadLabelElement = wait.until(ExpectedConditions.elementToBeClickable(uploadLabel));
            WebElement fileInputElement = driver.findElement(fileInput);
            
            js.executeScript("arguments[0].scrollIntoView(true);", uploadLabelElement);
            Thread.sleep(500);
            
            fileInputElement.sendKeys(filePath);
            System.out.println("✅ Logo uploaded successfully.");
            
        } catch (Exception e) {
            System.out.println("❌ Failed to upload logo: " + e.getMessage());
            throw e;
        }
    }
    
    public void saveLogo() throws InterruptedException {
        try {
            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
            js.executeScript("arguments[0].scrollIntoView(true);", save);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", save);
            System.out.println("💾 Logo saved successfully.");
            
        } catch (Exception e) {
            System.out.println("❌ Failed to save logo: " + e.getMessage());
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
}