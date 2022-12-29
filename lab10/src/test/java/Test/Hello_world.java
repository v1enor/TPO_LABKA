package Test;


import driver.DriverSingleton;
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


public class Hello_world extends CommonConditions{





    @Test(description = "TCH1")
    public void TCH1() {
        SearchPage searchPage = new SearchPage(webDriver);
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


}
