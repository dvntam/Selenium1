package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
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
    public void beforeMethod(){
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
    public void userCanLogIntoRailwayWithValidCredentials() {
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

//    public void TC01() {
//        System.out.println("TC01- User can log into Railway with valid HomePage username and password");
//        HomePage homePage = new HomePage();
//        homePage.open();
//
//        LoginPage loginPage = homePage.gotoLoginPage();
//        String actualMsg = loginPage.login(Constant.USERNAME, Constant. PASSWORD).getWelcomeMessage();
//        String expectedMsg = "Welcome"+ Constant.USERNAME;
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed");
//    }
//    public void TC02(){
//        System.out.println("TC02 -User can't login with blank \"Username\" textbox");
//        HomePage homePage = new HomePage();
//        homePage.open();
//
//        LoginPage loginPage = homePage.gotoLoginPage();
//        String actualMsg = loginPage.login(Constant.USERNAME ,Constant.PASSWORD).getWelcomeMessage();
//
//        Assert.assertEquals( actualMsg,"There was a problem with your login and/or errors exist in your form.");}



}
