package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FAQPage extends AbstractPage {

    @FindBy(xpath = "//input [@type='search']")
    private WebElement SearchInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement SearchSend;

    public FAQPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("Opened FAQPage");
    }

    public FAQPage SetRequest(String question)
    {
        WebElement ChooseWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(SearchInput));
        ChooseWait.sendKeys(question);
        logger.info("SetRequest");
        return this;

    }
    public FAQPage SendRequest()
    {

        WebElement SearchSendWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(SearchSend));
        SearchSendWait.click();
        logger.info("SendRequest");
        return this;

    }

    public boolean CheckResultlOfGuetion()
    {
        logger.info("Check Results");

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//div[@class='search-results']")).size() != 0;
        return  exists;
    }
    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
