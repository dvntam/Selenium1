package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.BookTicketPage;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import DataObjects.MyTicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

    }

    @AfterMethod

    public void afterMethod() {

        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        // Step 1: Open the home page
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        LoginPage loginPage = homePage.gotoLoginPage();
        // Step 3: Attempt to login with a valid username and password
        String validUsername = "ngantam168@gmail.com";
        String validPassword = "123456789";
        String expectedWelcomeMessage = "Welcome " + validUsername;
        // Logging in and getting the actual welcome message
        String actualWelcomeMessage = loginPage.login(validUsername, validPassword).getWelcomeMessage();

        // Step 4: Verify that the welcome message is displayed
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome message is not displayed");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 -User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String validUsername = "";
        String validPassword = "123456789";
        String expectedWelcomeMessage = "Welcome " + validUsername;

        String actualWelcomeMessage = loginPage.login(validUsername, validPassword).getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "There was a problem with your login and/or errors exist in your form.");
    }
    @Test
    public void TC03() {
        System.out.println("TC02 -User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void TC4() {
        // Step 1: Open the home page
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        WebElement loginPage = driver.findElement(By.id("loginForm"));
        if (loginPage.isDisplayed()) {
            System.out.println("Test Passed: Login page is displayed when an un-logged user clicks on 'Book ticket' tab.");
        } else {
            System.out.println("Test Failed: Login page is not displayed as expected.");
        }

    }
    @Test
    public void TC05() {
        // Step 1: Open the home page or any page from where login is initiated
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        LoginPage loginPage = homePage.gotoLoginPage();
        // Step 3: Attempt to log in with the wrong password multiple times
        String username = "ngantam168@gmail.com";
        String wrongPassword = "123456780";

        for (int i = 0; i < 5; i++) {
            loginPage.login(username, wrongPassword);
        }
    }
    @Test
    public void TC06(){
        // Step 1: Open the home page or any page from where login is initiated
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        LoginPage loginPage = homePage.gotoLoginPage();
        //step3
        String validUsername = "ngantam168@gmail.com";
        String validPassword = "123456789";
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        Assert.assertEquals(myTicketPage.getLblMyTicket(),"Manage Ticket");




    }
}