ReeloAutomation
Project Overview
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
ReeloAutomation is a TestNG-based automation framework designed to validate and automate end-to-end campaign creation workflows in the Reelo application.
It uses the Page Object Model (POM) design pattern for better reusability and maintainability.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Project Structure
ReeloAutomation/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   ├── Fullplace/
│       │   │   └── sms.java
│       │   ├── pages/
│       │   │   ├── LoginPage.java
│       │   │   ├── CampaignPage.java
│       │   │   ├── ChannelSelectionPage.java
│       │   │   ├── CampaignSetupPage.java
│       │   │   ├── CreativePage.java
│       │   │   └── SMSPage.java
│       │   └── tests/
│       │       └── ReeloAutomationTest.java
│       └── resources/
│
├── pom.xml
├── target/
├── reports/
└── test-output/
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Tools and Frameworks Used
---------------------------

Programming Language: Java

Automation Framework: TestNG

Design Pattern: Page Object Model (POM)

Build Tool: Maven

WebDriver: Selenium WebDriver

Reporting: TestNG Reports

IDE: Eclipse
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

How to Clone the Repository

Once you’ve pushed your project to GitHub, others can clone it using:

git clone https://github.com/123githubatul/reelo_sms_automation.git
-----------------------------------------------------------------------------------------------------------------------------------------------------------------


Then, navigate to the project directory:

cd ReeloAutomation

-----------------------------------------------------------------------------------------------------------------------------------------------------------------

If you’re using Eclipse, you can also:

Open Eclipse → File → Import → Existing Maven Project

Browse to the cloned folder

Click Finish
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

How to Run the Tests
Prerequisites

Install Java 8 or above

Install Maven

Add both java and mvn to your system PATH

Ensure all dependencies are installed (Eclipse usually handles this automatically via Maven)

Steps to Execute

Option 1: From Eclipse

Right-click on the project reelo

Select Run As → Maven clean

Select Run As → Maven test

Or directly right-click ReeloAutomationTest.java → Run As → TestNG Test
-----------------------------------------------------------------------------------------------------------------------------------------------------------------


Option 2: From Command Line

cd C:\Users\Admin\eclipse-workspace\reelo
mvn clean test
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Test Flow Summary

LoginPage.java – Logs into the application

CampaignPage.java – Navigates to the campaign module

ChannelSelectionPage.java – Selects SMS as the preferred channel

CampaignSetupPage.java – Enters campaign title and description

CreativePage.java – Uploads a logo and proceeds

SMSPage.java – Fills in SMS text and sends a test campaign

ReeloAutomationTest.java – Integrates all above steps into one automated flow
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Report Location

After execution, reports are generated in:

test-output/

