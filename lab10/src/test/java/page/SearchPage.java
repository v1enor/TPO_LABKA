package page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchPage extends AbstractPage {



    @FindBy(xpath = "//div[@class='Input-module__title--SvJ1H\' and text()='Заезд']")
    private WebElement CheckIN;

    @FindBy(xpath = "//div[@data-day='Sat Mar 25 2023 00:00:00 GMT+0300 (Москва, стандартное время)']")
    private WebElement FirstDate;

    @FindBy(xpath = "//div[@data-day='Mon Mar 27 2023 00:00:00 GMT+0300 (Москва, стандартное время)']")
    private WebElement SecondDate;

    @FindBy(xpath = "//div[@class='InputRadio-module__container--23QtZ']")
    private WebElement WorkBtn;

    @FindBy(xpath = "//div[@class='Button-module__content--2FF16']")
    private WebElement Seacrh;

    @FindBy(xpath = "//input[@class='Input-module__control--tqFEn']")
    private WebElement DirectionInput;

    @FindBy(xpath = "//div[@title='Тбилиси, Грузия']")
    private WebElement FirstChoose;

    @FindBy(xpath = "//div[@title='Гостиница Four Seasons Hotel Moscow']")
    private WebElement FirstChooseHotel;

    @FindBy(xpath = "//a[@class='Link-module__link--2mX8m ClientLinks__link--3gnS1' and text()='База знаний']")
    private WebElement FAQBtn;

    @FindBy(xpath = "//a[@class='MobileApp__link--2hEP2 external']")
    private WebElement AndroidAPP;


    @FindBy(xpath = "//a[@class='zenblog-title link']")
    private WebElement BlogBtn;


    @FindBy(xpath = "//div[@class='SupportWidget-module__control--1Zl0h']")
    private WebElement SupportBtn;



    @FindBy(xpath = " //a [@class='SupportWidget-module__link--3LQab external']")
    private WebElement FedBackForn;


    @FindBy(xpath = "  //div [@class='zenradiobutton-text' and text()='Вопрос об отеле' ]")
    private WebElement AboutHotelRequest;
    // Page elements
    protected final String HOMEPAGE_URL = "https://ostrovok.ru";

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }



    @Override
    public SearchPage openPage()
    {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Opened Searchpage");
        return this;
    }

    public SearchPage enterReferences(String to)
    {
        WebElement Waitdir = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(DirectionInput));
        Waitdir.click();
        Waitdir.sendKeys(to);
        WebElement waitchoce = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(FirstChoose));
        waitchoce.click();


        return this;
    }



    public SearchPage enterHotel(String to)
    {
        WebElement Waitgotel = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(DirectionInput));
        Waitgotel.click();
        Waitgotel.sendKeys(to);
        WebElement waitchoce = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(FirstChooseHotel));
        waitchoce.click();


        return this;
    }
    public SearchPage enterDestination() {


        WebElement from = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(CheckIN));
        from.click();
        WebElement march = new WebDriverWait(driver, 10)
                 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Март' and @class='Month-module__title--3FEyE']")));
        march.click();
        WebElement firstdate = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(FirstDate));
        firstdate.click();

        WebElement second =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.visibilityOf(SecondDate));
        second.click();
        logger.info("Enter Destinion");
        return this;

    }

    public SearchPage enterWorkType(String work)
    {
        if (work == "Work")
        {
            WebElement WorkWait =
                    new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.elementToBeClickable(WorkBtn));
            WorkWait.click();
            logger.info("Enter enterWorkType");
            return this;
        }
        else{
            return this;
        }
    }

    public SearchPage Seacrh()
    {
        WebElement FindWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(Seacrh));
        FindWait.click();
        logger.info("Search");
        return this;
    }

    public SearchPage GoFooter()
    {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        return this;
    }
    public void OpenFAQ()
    {

        WebElement FAQBtnWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(FAQBtn));
        FAQBtnWait.click();
        return;
    }

    public SearchPage ClickAndroid() {
        WebElement AndroidAPPWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(AndroidAPP));
        AndroidAPPWait.click();
        return this;
    }

    public boolean ImgAndroidEXist()
    {

        logger.info("Check img AndroidAPP");

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//img [@class='MobileAppWidget-module__qrcode--2m2XM']")).size() != 0;
        return  exists;
    }

    public SearchPage OpenBlog()
    {
        WebElement BlogBtnWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(BlogBtn));
        BlogBtnWait.click();
        return this;
    }

    public SearchPage OpenSupport()
    {
        WebElement SupportBtnWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(SupportBtn));
        SupportBtnWait.click();
        return this;
    }

    public SearchPage OpenFeddbackSupport()
    {
        WebElement FedBackFornWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(FedBackForn));
        FedBackFornWait.click();
        return this;
    }

    public SearchPage ChoseHotelQuetionType()
    {
        WebElement AboutHotelRequestnWait =
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(AboutHotelRequest));
        AboutHotelRequestnWait.click();
        return this;
    }
    public boolean ExistForm()
    {
        logger.info("FeedBack Check");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//div [@class='zenfeedback-fields-inner' ]")).size() != 0;
        return  exists;
    }


}
