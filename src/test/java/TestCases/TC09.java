package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.ChangePasswordPage;
import DataObjects.GeneralPage;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC09 extends GeneralPage {
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
    public void TC09(){
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String validUsername = "ngantam168@gmail.com";
        String validPassword = "123456789";
        String expectedWelcomeMessage = "Welcome " + validUsername;
        String actualWelcomeMessage = loginPage.login(validUsername, validPassword).getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome message is not displayed");

        ChangePasswordPage changePasswordPage= homePage.gotoChangePassword();
        String PW = "123456789";
        String newPW = "1234567890";
        String confirmPW ="1234567890";
        String actMess = changePasswordPage.changPW(PW,newPW,confirmPW).getMessChange();
        boolean MessSuccess = Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message success']")).isDisplayed();
        if (MessSuccess) {
            System.out.println("mess appear");
        } else {
            System.out.println("mess don't appear");
        }

    }
}
