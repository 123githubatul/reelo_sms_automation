# ReeloAutomation

---

## Project Overview
ReeloAutomation is a TestNG-based automation framework designed to validate and automate end-to-end campaign creation workflows in the Reelo application.  
It follows the Page Object Model (POM) design pattern to ensure better reusability, maintainability, and scalability.

---

## Project Structure
```
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
```

---

## Tools and Frameworks Used
| Category | Tool / Framework |
|-----------|------------------|
| Programming Language | Java |
| Automation Framework | TestNG |
| Design Pattern | Page Object Model (POM) |
| Build Tool | Maven |
| WebDriver | Selenium WebDriver |
| Reporting | TestNG Reports |
| IDE | Eclipse |

---

## How to Clone the Repository
Once you’ve pushed your project to GitHub, others can clone it using:

```bash
git clone https://github.com/123githubatul/reelo_sms_automation.git
```

Then, navigate to the project directory:

```bash
cd ReeloAutomation
```

---

## Importing the Project in Eclipse
1. Open Eclipse  
2. Go to File → Import → Existing Maven Project  
3. Browse to the cloned folder  
4. Click Finish  

---

## How to Run the Tests

### Prerequisites
- Install Java 8 or above  
- Install Maven  
- Add both `java` and `mvn` to your system PATH  
- Ensure all dependencies are installed (Eclipse usually handles this automatically via Maven)

---

### Option 1: Run from Eclipse
1. Right-click on the project `reelo`  
2. Select **Run As → Maven clean**  
3. Select **Run As → Maven test**  
4. Or directly right-click `ReeloAutomationTest.java` → **Run As → TestNG Test**

---

### Option 2: Run from Command Line
```bash
cd C:\Users\Admin\eclipse-workspace\reelo
mvn clean test
```

---

## Test Flow Summary
| Step | Page Class | Description |
|------|-------------|-------------|
| 1 | LoginPage.java | Logs into the application |
| 2 | CampaignPage.java | Navigates to the campaign module |
| 3 | ChannelSelectionPage.java | Selects SMS as the preferred channel |
| 4 | CampaignSetupPage.java | Enters campaign title and description |
| 5 | CreativePage.java | Uploads a logo and proceeds |
| 6 | SMSPage.java | Fills in SMS text and sends a test campaign |
| 7 | ReeloAutomationTest.java | Integrates all above steps into one automated flow |

---

## Report Location
After execution, reports are generated in:
```
test-output/
```

---

## Author
**Atul Kumar Prajapathi**  
Email: [atulprajapathi@gmail.com](mailto:atulprajapathi@gmail.com)  
GitHub: [https://github.com/123githubatul](https://github.com/123githubatul)

---


