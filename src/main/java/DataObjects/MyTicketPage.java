package DataObjects;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    private final By _btnCancel = By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[11]/input");
    private final By _lblMyTicket = By.xpath("//*[@id=\"content\"]/h1");
    public WebElement getbtnCancel(){return Constant.WEBDRIVER.findElement(_btnCancel);}
    public WebElement getLblMyTicket(){
        return Constant.WEBDRIVER.findElement(_lblMyTicket);
    }
    public MyTicketPage cancelticket(){
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();",getbtnCancel());
        this.getbtnCancel().click();
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
        System.out.println("Canceled ticket");
        return new MyTicketPage();
    }
    public HomePage lblmyticket(String content){
        this.getLblMyTicket().sendKeys(content);
        return new HomePage();
    }



}