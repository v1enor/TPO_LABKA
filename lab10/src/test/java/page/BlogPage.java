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

public class BlogPage extends  AbstractPage{




    @Override
    protected AbstractPage openPage() {
        driver.navigate().to("https://blog.ostrovok.ru/?ref=ostrovok-mainpage");
        logger.info("Opened Blog");
        return this;
    }

    public BlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        driver.navigate().to("https://blog.ostrovok.ru/?ref=ostrovok-mainpage");
        logger.info("Opened BlogPage");
    }

    public BlogPage OpenByTag(String tag)

    {

        String Tag = "//a[text()='"+tag + "']";
        WebElement TagWait = new WebDriverWait(driver, 20)
            .until(ExpectedConditions.elementToBeClickable(By.xpath(Tag)));
        TagWait.sendKeys(tag);

        logger.info("Tag Select");
        return this;

    }

   public boolean ExistNewsTag(String tag)
   {
       logger.info("Check Results");
       //h1[text()='новости']
       String TagTest = "//h1[text()='" +tag.substring(1) + "']]";
       driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
       boolean exists = driver.findElements( By.xpath("TagTest")).size() != 0;
       return  exists;
   }


}
