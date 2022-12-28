package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinHome;
import page.SearchPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Hello_world {

    public static void main(String[] args) throws InterruptedException {

    }
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod (alwaysRun = true)
    public void browserQuite(){
        driver.quit();
        driver = null;
    }

    public void ICanWin(){
        PasteBinHome pasteBinPage = new PasteBinHome(driver);
        pasteBinPage.openPage().inputMessage("Hello from WebDriver")
                .setBashSyntax()
                .setExpirationTimeToTenMinutes()
                .setPasteName("helloweb")
                .pressConfirmButton();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Thread.sleep(1000); // pause for 1 second
        } catch (InterruptedException e) {
            // the thread was interrupted while sleeping
            e.printStackTrace();
        }

        Assert.assertTrue(pasteBinPage.isSuccessConfirmationForICanWin(), "Confirmation is not successful!!!");
    }


    public void BringItOn() {
        PasteBinHome pasteBinPage = new PasteBinHome(driver);
        String inputMessage =   "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        pasteBinPage.openPage().inputMessage(inputMessage)
                .setBashSyntax()
                .setExpirationTimeToTenMinutes()
                .setPasteName("how to gain dominance among developers")
                .pressConfirmButton();

        try {
            Thread.sleep(3000); // pause for 3 second
        } catch (InterruptedException e) {
            // the thread was interrupted while sleeping
            e.printStackTrace();
        }
        Assert.assertEquals("how to gain dominance among developers - Pastebin.com", driver.getTitle());
        Assert.assertEquals("Bash", driver.findElement(By.xpath("//a[@class='btn -small h_800']")).getText());
        Assert.assertEquals(pasteBinPage.openRaw().getCodeText(), inputMessage);
    }


    @Test(description = "TCH1")
    public void TCH1() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        searchPage.enterDestination("Тбилиси, Грузия");
        searchPage.enterDates();
        searchPage.selectWorkTrip();
        searchPage.selectGuests();
        searchPage.search();
        searchPage.sleep(10);
        searchPage.sortByPrice();
        searchPage.sleep(3);
        boolean sorted = searchPage.isSortedByPrice();
        Assert.assertTrue(sorted, "тест по нахождению дешевого отеля успешно ЗАВАЛЕН");
    }

    public void TCH2() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        searchPage.enterDestination("Тбилиси, Грузия");
        searchPage.search();
        searchPage.sleep(10);
        searchPage.changeCurrency("usd");
        searchPage.sleep(3);
        boolean sorted = searchPage.checkCurrency("usd");
        Assert.assertTrue(sorted, "тест по смене валют успешно ЗАВАЛЕН");
    }
}
