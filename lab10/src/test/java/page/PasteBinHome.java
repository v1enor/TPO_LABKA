package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinHome {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    private static final String mainInputAreaId = "postform-text";
    private static final String syntaxFormatListId = "select2-postform-format-container";
    private static final String expirationListId = "select2-postform-expiration-container";
    private static final String pasteNameAreaId = "postform-name";

    public PasteBinHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHome openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinHome openRaw() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement openRawButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='raw' and @class='btn -small']")));
        openRawButton.click();
        return this;
    }

    public PasteBinHome inputMessage(String message) {
        driver.findElement(By.id(mainInputAreaId)).sendKeys(message);
        return this;
    }

    public PasteBinHome setBashSyntax()
    {
        driver.findElement(By.id(syntaxFormatListId)).click();
        String selectedSyntaxFormat = "//li[text()='Bash']";
        driver.findElement(By.xpath(selectedSyntaxFormat)).click();
        return this;
    }

    public PasteBinHome setExpirationTimeToTenMinutes() {
        driver.findElement(By.id(expirationListId)).click();
        String selectedTimeBlock = "//li[text()='10 Minutes']";
        driver.findElement(By.xpath(selectedTimeBlock)).click();
        return this;
    }

    public PasteBinHome setPasteName(String pasteName) {
        driver.findElement(By.id(pasteNameAreaId)).sendKeys(pasteName);
        return this;
    }
    public PasteBinHome pressConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement confirmButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn -big']")));
        confirmButton.click();
        return this;
    }
    public boolean isSuccessConfirmationForICanWin() {
        String successNoteXpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div";
        return driver.findElement(By.xpath(successNoteXpath)).isDisplayed();
    }
    public String getCodeText() {
        return driver.findElement(By.xpath("/html/body/pre")).getText();
    }
}