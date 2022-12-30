package webDriver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() { }

    public static WebDriver getDriver() {
//        String mvnProperty = System.getProperty("browser");
        String mvnProperty = "chrome";
        if (null == driver) {
            switch (mvnProperty) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    return driver;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

                    return driver;
                }
            }
        }
        driver.manage().window().maximize();
        return driver;
    }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}