package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResultsPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='zenformselect-inner']")
    private WebElement SortChoose;

    @FindBy(xpath = "//li[@data-name='price.asc']")
    private WebElement PriceLow;

    @FindBy(xpath = "//p[@class='zenformselect-value']")
    private WebElement PriceText;

    @FindBy(xpath = "//div[@class='CurrencyWidget-module__control--2HKpK']")
    private WebElement CurrencyControler;

    @FindBy(xpath = "//input[@class='Input-module__control--tqFEn' and @placeholder='Название валюты']")
    private WebElement CurrencyInput;

    @FindBy(xpath = "//div[@class='CurrencyWidget-module__code--35T_2']")
    private WebElement CurrencyChosee;

    @FindBy(xpath = "//div[@class='CurrencyWidget-module__value--39Qta']")
    private WebElement CurrencySelected;



    @FindBy(xpath = "//div[@data-testid='language-widget-control']")
    private WebElement LanguageControler;

    @FindBy(xpath = "//div[@class='LanguageWidget-module__value--3EPLn']")
    private WebElement LanguageName;


    @FindBy(xpath = "//input [@class='zenforminputcontrol ' and @name='price_from' ]")
    private WebElement FromPrice;

    @FindBy(xpath = "//input [@class='zenforminputcontrol ' and @name='price_to' ]")
    private WebElement ToPrice;

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("Opened ResultsPage");
    }
    public ResultsPage GoFooter()
    {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        return this;
    }

    public ResultsPage SortByPrice(){


        WebElement ChooseWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(SortChoose));
        ChooseWait.click();

        WebElement ChoosePrice = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(PriceLow));
        ChoosePrice.click();
        logger.info("Sorted ByPrice");
        return this;
    }

    public boolean checkIfSortedByLowerPrice(){
        WebElement PriceTextWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(PriceText));

        logger.info("checkIfSortedByLowerPrice");
        return PriceTextWait.getText().equals("Сначала дешевые");

    }


    public ResultsPage ChangeCurrency(String currency)
    {
        WebElement WaitCurrency = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(CurrencyControler));
        WaitCurrency.click();

        WebElement WaitCurrencyInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(CurrencyInput));
        WaitCurrencyInput.sendKeys(currency);

        WebElement WaitCurrencyChosee = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(CurrencyChosee));
        WaitCurrencyChosee.click();

        logger.info("changed money $$$$$$$");
        return this;
    }

    public boolean CheckCurrencyName(String CurrencyName)
    {
        WebElement WaitCheckCurrencyName = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(CurrencySelected));
        logger.info("CheckCurrencyName");
        return WaitCheckCurrencyName.getText().substring(0, 3).equals(CurrencyName);

    }

    public ResultsPage OpenLanguageModal()
    {
        WebElement WaitLangModal = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(LanguageControler));
        WaitLangModal.click();
        logger.info("Открыто окно языков");
        return this;
    }

    public ResultsPage ChangeLang(String Lang)
    {
        String reg = "//div[text()='" + Lang + "']";
        WebElement WaitLang = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(reg)));
        WaitLang.click();
        logger.info("Язык поменяl");
        return this;
    }


    public boolean CheckSelectedLan(String Lang)
    {

        WebElement WaitLanguageName = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(LanguageName));

        logger.info("Язык сравнил");
        return  WaitLanguageName.getText().equals(Lang);

    }


    public ResultsPage SetFiveStar()
    {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement WaitFive = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.
                        presenceOfElementLocated(By.xpath("//*[@id=\':6\']/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[13]/div/div[2]/div[1]/div/label/div[1]")));
        WaitFive.click();
        return this;
    }

    public ResultsPage filterPrice(String from, String to)
    {
        WebElement WaitFromPrice = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(FromPrice));
        WaitFromPrice.click();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        WaitFromPrice.sendKeys(Keys.BACK_SPACE);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        WaitFromPrice.sendKeys(from);

        WebElement ToPriceWait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(ToPrice));
        ToPriceWait.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        ToPriceWait.sendKeys(Keys.BACK_SPACE);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        ToPriceWait.sendKeys(to);
        return this;
    }



    public boolean CheckFilterResults()
    {
        logger.info("Check Filtred");

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath("//div[@class='zen-hotels-list-wrapper']")).size() != 0;
        return  exists;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
