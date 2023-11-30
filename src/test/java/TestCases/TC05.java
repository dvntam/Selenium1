package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05 {
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

}