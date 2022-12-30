package page;

import Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hotel extends AbstractPage{

    @FindBy(xpath = "//a[@class='zenroomspage-b2c-rates-book button-view-primary button-size-s']")
    private WebElement Book;


    @FindBy(xpath = "//input[@class='zenforminputcontrol ' and @name='room0.0FirstName']")
    private WebElement Name;

    @FindBy(xpath = "//input[@class='zenforminputcontrol ' and @name='room0.0LastName']")
    private WebElement NameSec;

    @FindBy(xpath = "//input[@class='zenforminputcontrol ' and @name='email']")
    private WebElement Email;

    @FindBy(xpath = " //input[@class='zenforminputcontrol ' and @name='phone']")
    private WebElement Phone;

    @FindBy(xpath = " //button[@class='zen-booking-stepbar-continue button-view-primary button-size-m']")
    private WebElement Bron;

    public Hotel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("Opened Hotel");
    }

    public Hotel BookNow()
    {
        WebElement BookWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(Book));
        BookWait.click();
        logger.info("Book");
        return this;
    }

    public Hotel Order (User user)
    {
        WebElement NameWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(Name));
        NameWait.sendKeys(user.getSecondName());

        WebElement NameSecWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(NameSec));
        NameSecWait.sendKeys(user.getUsername());

        WebElement PhoneWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(Phone));
        PhoneWait.sendKeys(user.getNumber());

        WebElement EmailWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(Email));
        EmailWait.sendKeys(user.getEmail());

        return this;
    }

    public Hotel Reservation ()
    {
        WebElement BronWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(Bron));
        BronWait.click();
        return this;
    }

    public boolean IsResrved(){
        logger.info("CreditationTEst");

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//div[@class='zen-booking-creditcard-main']")).size() != 0;
        return  exists;

    }

    public boolean ReviewExst(){
        logger.info("CreditationTEst");

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//p[@class='zenroomspagereviews-content-title']")).size() != 0;
        return  exists;

    }
    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
