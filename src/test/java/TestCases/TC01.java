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

public class TC01 {
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
}