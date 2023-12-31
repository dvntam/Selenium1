package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import DataObjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC08 {
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
    public void TC08()  {
        HomePage homePage = new HomePage();
        homePage.open() ;

        System.out.println("TC08 - User can't login with an account hasn't been activated");
        LoginPage loginPage = homePage.gotoLoginPage();
        String username= "ngantam168@gmail.com";
        String password = "123456789";
        String actualWelcomeMessage = loginPage.login(username, username).getWelcomeMessage();
        String expected = "Invalid username or password. Please try again.";
        String actual = Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']")).getText();
        if (actual.contains(expected)) {
            System.out.println("Mess is displayed correctly");
        } else {
            System.out.println("mess is not displayed correctly");
        }
    }

}
