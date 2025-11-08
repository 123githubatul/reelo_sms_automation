package fullplace;
 
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class sms{
 
    @Test
    public void login() throws InterruptedException {
 
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.reelo.io/login");
        driver.manage().window().maximize();
        // Click using JS (safer for dynamic menus)
        JavascriptExecutor js = (JavascriptExecutor) driver;
 
        driver.findElement(By.id("email")).sendKeys("atulprajapathi@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Outlook@123");
        driver.findElement(By.xpath("//span[@class='button-text']")).click();
 
        // Wait for dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement campaign = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'menu-title') and normalize-space()='Campaigns']")
        ));
        
       
        js.executeScript("arguments[0].click();", campaign);
        
 
        WebElement template = wait.until(ExpectedConditions.visibilityOfElementLocated(
        	    By.xpath("//h4[contains(text(), 'Nacho Day’s Here — Let’s Get Cheesy! 🧀')]")
        	));
 
        	// Smooth scroll directly to it
        	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", template);
        	Thread.sleep(3000);
        	js.executeScript("arguments[0].click();", template);
        	
        	
        	//click on templatesms
        	
            WebElement templatesms = wait.until(ExpectedConditions.visibilityOfElementLocated(
            	    By.xpath("//div[normalize-space()='SMS']")
            	));
     
            	// Smooth scroll directly to it
            	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", templatesms);
            	Thread.sleep(3000);
            	js.executeScript("arguments[0].click();", templatesms);
            	
            	Thread.sleep(3000);
        	
        	//Customise and Send
        	
        	WebElement customiseSendBtn = wait.until(ExpectedConditions.elementToBeClickable(
        		    By.xpath("//span[normalize-space()='Customise and Send']")
        		));

        		
        		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", customiseSendBtn);
        		Thread.sleep(1000);
        		js.executeScript("arguments[0].click();", customiseSendBtn);
        		System.out.println("✅ Clicked on 'Customize and Send' successfully!");
        	
        	//step1
        	
        	//undo email check box 
//        	WebElement select_channels = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//div[@class='channel channel-selected']//input[@type='checkbox']")
//        	        ));
//        	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", select_channels);
//    		Thread.sleep(1000);
//    		js.executeScript("arguments[0].click();", select_channels);
//    		System.out.println("✅ Clicked on 'select_channels' successfully!");
        	
        		// assume wait, driver, js already exist
        		// Locate all channels (both SMS and Email)
        		
        		
        	

        		// STEP: Select only SMS channel
        		try {
        		   

        		    // Wait for channels to load
        		    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
        		        By.xpath("//div[contains(@class,'channel')]")
        		    ));

        		    // Deselect all selected channels first
        		    java.util.List<WebElement> selectedChannels = driver.findElements(
        		        By.xpath("//div[contains(@class,'channel channel-selected')]")
        		    );
        		    for (WebElement channel : selectedChannels) {
        		        String label = channel.getText();
        		        if (!label.toLowerCase().contains("sms")) {  // Deselect everything except SMS
        		            js.executeScript("arguments[0].click();", channel);
        		            Thread.sleep(400);
        		        }
        		    }

        		    // Locate the SMS channel
        		    WebElement smsChannel = driver.findElement(
        		        By.xpath("//div[contains(@class,'channel')]//*[contains(translate(text(),'sms','SMS'),'SMS')]/ancestor::div[contains(@class,'channel')]")
        		    );

        		    // Scroll to view
        		    js.executeScript("arguments[0].scrollIntoView(true);", smsChannel);
        		    Thread.sleep(400);

        		    // Check if it's already selected
        		    String smsClass = smsChannel.getAttribute("class");
        		    if (!smsClass.contains("channel-selected")) {
        		        js.executeScript("arguments[0].click();", smsChannel);
        		        System.out.println("✅ SMS channel selected successfully!");
        		    } else {
        		        System.out.println("✅ SMS channel was already selected — no change made.");
        		    }

        		} catch (Exception e) {
        		    System.out.println("❌ Failed to ensure only SMS is selected: " + e.getMessage());
        		}







        	
        		// Wait for all checkbox elements to be present
        		
    		
////    		// STEP 1 - NEXT BUTTON
    		WebElement nextButton = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
    		System.out.println("✅ Clicked on 'select_channels' successfully!"+nextButton.toString());
    		
    		js.executeScript("arguments[0].click();", nextButton);
    		
    		
    		//step 2 
    		// Wait for the title input field to appear
    		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
    			    By.xpath("//input[@placeholder='Enter Title']")
    			));

    			// Highlight
    			js.executeScript("arguments[0].style.border='2px solid blue'", title);

    			// Click and FULLY clear using CTRL+A + DELETE
    			title.click();
    			title.sendKeys(Keys.chord(Keys.CONTROL, "a"));  // Select all
    			title.sendKeys(Keys.DELETE);                    // Delete existing text
    			Thread.sleep(300);

    			// Now send new title
    			title.sendKeys("atul");
    			System.out.println("✅ Title set successfully!");
    			
    			
    		// Wait for description textarea
    		WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(
    		    By.xpath("//textarea[@name='subtitle']")
    		));

    		// Highlight and input description
    		js.executeScript("arguments[0].style.border='2px solid green'", description);
    		description.click();
    		description.clear();
    		description.sendKeys("This is for testing purpose");
    	    
    		//NEXT BUTTON2
    		WebElement nextButton2 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
    		System.out.println("✅ Clicked on 'select_channels' successfully!"+nextButton2.toString());
    		
    		js.executeScript("arguments[0].click();", nextButton2);
    		

    		
    		
    		// ✅ Add mobile number (target the input INSIDE the input-row)
    		WebElement contactInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
    		    By.xpath("//div[@class='prefix-value-suffix-row']")
    		));

    		try {
    		    // Try blur first
    		    js.executeScript("arguments[0].blur();", contactInput);
    		} catch (Exception e) {
    		    System.out.println("⚠️ Blur failed, clicking outside instead...");
    		}

    		// Click on any stable area outside (header, label, etc.)
    		WebElement outsideArea = wait.until(ExpectedConditions.visibilityOfElementLocated(
    		    By.xpath("//div[contains(@class,'campaign-edit-screens')]")
    		));
    		js.executeScript("arguments[0].click();", outsideArea);
    		System.out.println("✅ Clicked outside contact field to remove focus.");
    		Thread.sleep(700);
    		
    		
    		
    		

    		
    		
    		
    		//NEXT BUTTON3
    		// ✅ NEXT BUTTON 3 - SAFE WAY
    		try {
    		    WebElement nextButton3 = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//button[normalize-space()='Next']")
    		    ));

    		    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", nextButton3);
    		    Thread.sleep(500); // short wait to ensure rendering complete
    		    js.executeScript("arguments[0].click();", nextButton3);
    		    System.out.println("✅ Clicked on 'Next Button 3' successfully!");
    		} catch (Exception e) {
    		    System.out.println("❌ Failed to click Next Button 3: " + e.getMessage());
    		}
    		
    		//uplaod logo
    		
    		try {
    		    

    		    // Wait until the upload label is visible
    		    WebElement uploadLabel = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//label[@for='logo-upload']")
    		    ));

    		    // Find the hidden file input field
    		    WebElement fileInput = driver.findElement(By.id("logo-upload"));

    		    // Provide your file path (absolute path)
    		    String filePath = "C:\\Users\\Admin\\Desktop\\logo.jpg";

    		    // Scroll into view
    		    js.executeScript("arguments[0].scrollIntoView(true);", uploadLabel);
    		    Thread.sleep(500);

    		    // Send file path directly to input element
    		    fileInput.sendKeys(filePath);
    		    System.out.println("✅ Logo uploaded successfully.");
    		    
    		    //save the logo
    		    
    		 // Wait for the Save button to be clickable
    		    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//button[@class='sb-button sb-button--sm sb-button--full-width sb-button--primary']")
    		    ));

    		    // Scroll and click Save
    		    js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
    		    Thread.sleep(500);
    		    js.executeScript("arguments[0].click();", saveButton);

    		    System.out.println("💾 Logo saved successfully.");

    		} catch (Exception e) {
    		    System.out.println("❌ Failed to upload logo: " + e.getMessage());
    		}
    		
    		
    		
    		//NEXT BUTTON3
    		// ✅ NEXT BUTTON 4 - SAFE WAY
    		try {
    		    WebElement nextButton4 = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//button[normalize-space()='Next']")
    		    ));

    		    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", nextButton4);
    		    Thread.sleep(500); // short wait to ensure rendering complete
    		    js.executeScript("arguments[0].click();", nextButton4);
    		    System.out.println("✅ Clicked on 'Next Button 3' successfully!");
    		} catch (Exception e) {
    		    System.out.println("❌ Failed to click Next Button 3: " + e.getMessage());
    		}

    	      
    		// add final sms text
    		
    		try {
    		    

    		    // Wait until editable text fields appear
    		    List<WebElement> editableFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
    		        By.xpath("//div[@class='textarea']//*[self::input or @contenteditable='true']")
    		    ));

    		    System.out.println("Found " + editableFields.size() + " editable fields.");

    		    // Campaign-style catchy lines (≤ 12 chars each)
    		    String[] promoText = {
    		        "CheesyBite",       // Field 1
    		        "By Atul!",         // Field 2
    		        "NachoTime",        // Field 3
    		        "TastyWay!",        // Field 4
    		        "AtulCorner",       // Field 5
    		        "SnackJoy!",        // Field 6
    		        "CheeseHub",        // Field 7
    		        "YumTreats",        // Field 8
    		        "JoinToday!",       // Field 9
    		        "FeelCheesy"        // Field 10
    		    };

    		    int count = 0;
    		    for (WebElement field : editableFields) {
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
    		}

    		//NEXT BUTTON3
    		// ✅ NEXT BUTTON 5 - SAFE WAY
    		try {
    		    WebElement nextButton5 = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//button[normalize-space()='Next']")
    		    ));

    		    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", nextButton5);
    		    Thread.sleep(500); // short wait to ensure rendering complete
    		    js.executeScript("arguments[0].click();", nextButton5);
    		    System.out.println("✅ Clicked on 'Next Button 5' successfully!");
    		} catch (Exception e) {
    		    System.out.println("❌ Failed to click Next Button 5: " + e.getMessage());
    		}
    		
    		
    		//test campaing
    		try {
    		    WebElement testcampaing = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//span[normalize-space()='Test campaign']")
    		    ));

    		    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", testcampaing);
    		    Thread.sleep(500); // short wait to ensure rendering complete
    		    js.executeScript("arguments[0].click();", testcampaing);
    		    System.out.println("testcampaing sent succesfully");
    		    Thread.sleep(6000);
    		    
    		} catch (Exception e) {
    		    System.out.println("❌ Failed to testcampaing sent succesfully " + e.getMessage());
    		}
    		
    		//saveandexit
    		
    		try {
    		    WebElement saveandexit = wait.until(ExpectedConditions.elementToBeClickable(
    		        By.xpath("//button[normalize-space()='Save and exit']")
    		    ));

    		    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", saveandexit);
    		    Thread.sleep(500); // short wait to ensure rendering complete
    		    js.executeScript("arguments[0].click();", saveandexit);
    		    System.out.println("saveandexit succesfully");
    		    
    		    Thread.sleep(5000);
    		    
    		} catch (Exception e) {
    		    System.out.println("❌ Failed to saveandexit " + e.getMessage());
    		}
    		
    		driver.quit();
    	        
    	    } 
    
    		
    	
       
    }
