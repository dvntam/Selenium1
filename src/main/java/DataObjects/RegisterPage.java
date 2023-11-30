package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends HomePage{
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@value = 'Register']");
    private final By lblSuccessMessage = By.xpath("//div[@id='content']");
    private final By lblErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblValidationError = By.xpath("//label[contains(text(), 'Invalid password length') or contains(text(), 'Invalid ID length')]");

    //Elements
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPID(){
        return Constant.WEBDRIVER.findElement(_txtPID);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    protected WebElement getlblSuccessMessage(){
        return Constant.WEBDRIVER.findElement(lblSuccessMessage);
    }
    protected WebElement getlblErrorMessage(){
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }
    protected WebElement getlblInvalidMessage(){
        return Constant.WEBDRIVER.findElement(lblValidationError);
    }

    public String getSuccessMessage(){
        return this.getlblWelcomeMessage().getText();
    }
    public HomePage register(String email, String password, String confirmPassword, String PIP){
        //Register information
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(PIP);
        this.getBtnRegister().click();
        //show message
        return new HomePage();
    }
}
