package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import DataObjects.MyTicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06 {
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
    WebElement driver;
    @Test
    public void TC06() {
        HomePage homePage = new HomePage();
        homePage.open();
        // Step 2: Navigate to the login page
        LoginPage loginPage = homePage.gotoLoginPage();
        // Step 3: Attempt to login with a valid username and password
        String username = "ngantam168@gmail.com";
        String password = "123456789";
        // Logging in and getting the actual welcome message
        HomePage actualWelcomeMessage = loginPage.login(username, password);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
       // Kiểm tra xem đã vào đúng trang ticket chưa
        boolean headerpost = driver.findElement(By.xpath("//h1[normalize-space()='Manage ticket']")).isDisplayed();
        if (headerpost == true) {
            System.out.println("Đã đến trang My ticket");
        } else {
            System.out.println("Không đến trang My ticket");
        }
        // Click "Chane password"
        WebElement change_password = driver.findElement(By.xpath("//span[normalize-space()='Change password']"));
        change_password.click();
        boolean headerpost2 = driver.findElement(By.xpath("//h1[normalize-space()='Change password']")).isDisplayed();
        if (headerpost2 == true) {
            System.out.println("Đã đến trang change password");
        } else {
            System.out.println("Không đến trang change password");

        }
    }
}