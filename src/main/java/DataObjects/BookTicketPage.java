package DataObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    WebDriver driver;
    private final By _txtUsername = By.xpath("//input[@id='username']");

    // Các phương thức và thuộc tính khác

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        // Step 4: Select a "Depart date" from the list
        selectDepartDate(departDate);

        // Step 5: Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at"
        selectDepartFromAndArriveAt(departFrom, arriveAt);

        // Step 6: Select "Soft bed with air conditioner" for "Seat type"
        selectSeatType(seatType);

        // Step 7: Select "1" for "Ticket amount"
        selectTicketAmount(ticketAmount);

        // Click on "Book ticket" button
        WebElement bookTicketButton = driver.findElement(By.xpath("//input[@value='Book ticket']"));
        bookTicketButton.click();
    }

    // Các phương thức hỗ trợ

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
        WebElement successMessageElement = driver.findElement(By.xpath("//div[@id='bar']//p[@class='message success']"));
        return successMessageElement.getText();
    }

    public boolean isTicketInformationCorrect(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        // Implement logic to verify ticket information
        return true;  // Placeholder, actual implementation needed
    }

}
