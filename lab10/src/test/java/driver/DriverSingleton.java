package driver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver webDriver;
    public static WebDriver getDriver()
    {
        if(null==webDriver)
        {
//            switch (System.getProperty("browser")) {
//                case "firefox": {
//                    WebDriverManager.firefoxdriver().setup();
//                    webDriver = new FirefoxDriver();
//                }
//                default: {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

//                }

        }
        return webDriver;

    }

    public static  void closeDriver()
    {
        webDriver.quit();
        webDriver=null;
    }
}