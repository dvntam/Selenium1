package DataObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By _txtUsername = By.xpath("//input[@id='username']");

    private final By departdate = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[1]/select");
    private final By departfrom = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select");
    private final By departarrive = By.xpath("//*[@id=\"ArriveStation\"]/select");
    private final By departtype = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[4]/select");
    private final By departamount = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[5]/select");

    private final By btnBook = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/input");
    public WebElement getdepartdate(){
        return Constant.WEBDRIVER.findElement(departdate);
    }
    public WebElement getdepartfrom(){
        return Constant.WEBDRIVER.findElement(departfrom);
    }
    public WebElement getdepartarrive(){
        return Constant.WEBDRIVER.findElement(departarrive);
    }
    public WebElement getdeparttype(){
        return Constant.WEBDRIVER.findElement(departtype);
    }
    public WebElement getdepartamount(){
        return Constant.WEBDRIVER.findElement(departamount);
    }
    public WebElement getbtnBook(){
        return Constant.WEBDRIVER.findElement(btnBook);
    }
    private void selectDepartDate(String departDate) {
        // Implement logic to select depart date from the list
    }
    private void selectDepartFromAndArriveAt(String departFrom, String arriveAt) {
        // Implement logic to select depart from and arrive at
    }
    private void selectSeatType(String seatType) {
        // Implement logic to select seat type
    }
    private void selectTicketAmount(String ticketAmount) {
        // Implement logic to select ticket amount
    }
    public String getSuccessMessage() {
        WebElement successMessageElement = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='bar']//p[@class='message success']"));
        return successMessageElement.getText();
    }
    public boolean isTicketInformationCorrect(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        // Implement logic to verify ticket information
        return true;  // Placeholder, actual implementation needed
    }
    public BookTicketPage bookticket(int date,int from, int arrive, int type, int amount){
        Select departdate =new Select(getdepartdate());
        departdate.selectByIndex(date);

        Select departfrom =new Select(getdepartfrom());
        departfrom.selectByIndex(from);

        Select departarrive =new Select(getdepartarrive());
        departarrive.selectByIndex(arrive);

        Select departtype =new Select(getdeparttype());
        departtype.selectByIndex(type);

        Select departamount =new Select(getdepartamount());
        departamount.selectByIndex(amount);

        this.getbtnBook().click();
        return new BookTicketPage();
    }

}