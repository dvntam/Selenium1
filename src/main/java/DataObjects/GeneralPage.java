package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement tabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement tabMyTicket() { return Constant.WEBDRIVER.findElement(tabMyTicket);}
    protected WebElement tabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected WebElement tabRegister(){ return Constant.WEBDRIVER.findElement(tabRegister);}
    //Methods
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public BookTicketPage gotoBookTicketPage(){
        this.tabBookTicket().click();
        return new BookTicketPage();
    }
    public MyTicketPage gotoMyTicketPage(){
        this.tabMyTicket().click();
        return new MyTicketPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.tabRegister().click();
        return new RegisterPage();
    }
    public boolean gotoChangePassword(){
        this.tabChangePassword().isDisplayed();
        return true;
    }



}
