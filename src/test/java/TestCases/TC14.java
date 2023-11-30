package TestCases;

import Common.Constant;
import Common.Utilities;
import DataObjects.BookTicketPage;
import DataObjects.HomePage;
import DataObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC14 {
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
    public  void TC14(){
        System.out.println("TC14- User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String Username = "ngantam168@gmail.com";
        String Password = "123456789";
        String actualMsg = loginPage.login(Username, Password).getWelcomeMessage();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        bookTicketPage.bookticket(3,0,1,5,0);
    }

}
