package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC03 {
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
    public void TC03() {
        System.out.println("TC03 -User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String validUsername = "ngantam168@gmail.com";
        String validPassword = "0123456789";
        String expectedWelcomeMessage = "Welcome " + validUsername;

        String actualWelcomeMessage = loginPage.login(validUsername, validPassword).getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "There was a problem with your " +
                "login and/or errors exist in your form.");

    }
}