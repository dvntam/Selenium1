package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.BookTicketPage;
import DataObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC04 {
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
    public void TC4() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        // Step 1: Open the home page
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

    }
}