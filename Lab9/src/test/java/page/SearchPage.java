package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    // Page elements
    private WebElement directionField;
    private WebElement checkInDateField;
    private WebElement checkOutDateField;
    private WebElement workTripButton;
    private WebElement guestsField;
    private WebElement searchButton;
    private WebElement hotelNameField;
    private WebElement hotelLocationField;


    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000); // pause for 3 second
        } catch (InterruptedException e) {
            // the thread was interrupted while sleeping
            e.printStackTrace();
        }
    }
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://ostrovok.ru");
    }

    public void enterDestination(String destination) {
        directionField = driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/label/div[1]/input"));
        directionField.sendKeys(destination);
        sleep(10);
        directionField.sendKeys(Keys.RETURN);
    }

    public void enterDates() {
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div[1]/label/div[1]/div")).click();
        sleep(1);
        driver.findElement(By.xpath("/html/body/div[7]/div[1]/div/div[6]/div")).click();
        sleep(1);
        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[3]/div[6]/div[5]/div[6]/div")).click();

        //Дата выезда
        sleep(1);
        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[3]/div[6]/div[6]/div[1]/div")).click();

        // select check-in date
        // select check-out date
    }

    public void selectWorkTrip() {
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[5]/div/div/label[2]/div/span[1]")).click();

    }

    public void selectGuests() {
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[3]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]")).click();


        // select the number of guests
    }

    public void search() {
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[4]/button")).click();
    }

    public void selectHotel(String hotelName, String hotelLocation) {
        hotelNameField.click();
        // select hotel based on name and location
    }

    public void sortByPrice() {
        sleep(3);
        driver.findElement(By.xpath("//*[@id=\":2\"]/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[3]/div/div[2]/div/div[1]")).click();
        sleep(4);
        driver.findElement(By.xpath("//*[@id=\":2\"]/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[3]/div/div[2]/div/div[2]/div/div/ul/li[2]")).click();
    }



    public boolean isSortedByPrice() {
        String sortType = driver.findElement(By.xpath("//*[@id=\":2\"]/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[3]/div/div[2]/div/div[1]/p")).getText();
        boolean results = sortType.equals("Сначала дешевые");
        return results;
    }
}
