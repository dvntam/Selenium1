package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locators
    private final By _txtcurrentPW = By.xpath("//input[@id='currentPassword']");
    private final By _txtnewPW = By.xpath("//input[@id='newPassword']");
    private final By _txtconfirmPW = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangepassword = By.xpath("//input[@type='submit']");
    private final By _MessChange = By.xpath("//p[@class='message success']");
    //Elements

    public WebElement getTxtCurentPw(){
        return Constant.WEBDRIVER.findElement(_txtcurrentPW);
    }
    public WebElement getTxtNewPw(){
        return Constant.WEBDRIVER.findElement(_txtnewPW);
    }
    public WebElement getTxtConfirmPw(){
        return Constant.WEBDRIVER.findElement(_txtconfirmPW);
    }
    public WebElement getlblMessChange(){
        return Constant.WEBDRIVER.findElement(_MessChange);
    }
    public WebElement getBtnChangePw(){
        return Constant.WEBDRIVER.findElement(_btnChangepassword);
    }

    //Methods
    public String getMessChange(){
        return this.getlblMessChange().getText();
    }
    public ChangePasswordPage changPW (String currentpass, String newpass, String confirm){
        //Submit login credentials
        this.getTxtCurentPw().sendKeys(currentpass);
        this.getTxtNewPw().sendKeys(newpass);
        this.getTxtConfirmPw().sendKeys(confirm);
        this.getBtnChangePw().click();
        //land on HomePage
        return new ChangePasswordPage();
    }
}
