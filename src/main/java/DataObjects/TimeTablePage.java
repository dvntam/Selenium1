package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage {
    private final By _hplticketlink = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[2]/td[7]/a");

    public WebElement gethplTicketlink(){
        return Constant.WEBDRIVER.findElement(_hplticketlink);
    }

    public BookTicketPage clickTicket(){
        this.gethplTicketlink().click();
        return new BookTicketPage();
    }
}