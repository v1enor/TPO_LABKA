import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hello_world {
    public static void main(String[] args) throws InterruptedException {
        ICanWin();
    }


    public static void ICanWin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        WebElement CodePaste = driver.findElement(By.cssSelector("#postform-text"));
        CodePaste.sendKeys("Hello from WebDriver");


        driver.findElement(By.cssSelector("#select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
        driver.findElement(By.id("postform-name")).sendKeys("helloweb");


        Thread.sleep(4000);
        driver.quit();

    }

    public static void  BringItOn() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.findElement(By.id("postform-text")).sendKeys("git config --global user.name  \"New Sheriff in Town\"" +
                "\ngit reset $(git commit - tree HEAD ^{ tree} -m \"Legacy code\") " +
                "\ngit push origin master --force");

        driver.findElement(By.id("select2-postform-format-container")).click();
        driver.findElement(By.xpath("//li[text()='Bash']")).click();

        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();

        driver.findElement(By.id("postform-name")).sendKeys("how to gain dominance among developers");

        driver.findElement(By.xpath("//button[@class='btn -big']")).click();
        Thread.sleep(20000);

        WebElement syntax = (WebElement)driver.findElement(By.xpath("//a[text()='Bash']"));
        WebElement codeFirstLine = (WebElement)driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/ol/li[1]/div/span[1]"));
        WebElement codeSecondLine = (WebElement)driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/ol/li[2]/div/span[1]"));
        WebElement codeThirdLine = (WebElement)driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/ol/li[3]/div/span[1]"));



        driver.getTitle().equals("how to gain dominance among developers - Pastebin.com");
        syntax.getText().equals("Bash");
        codeFirstLine.getText().equals("git config");
        codeSecondLine.getText().equals("git reset");
        codeThirdLine.getText().equals("git push");


        Thread.sleep(4000);
        driver.quit();

    }

    public static void  TC_FH_1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ostrovok.ru");

        WebElement direction = driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/label/div[1]/input"));
        direction.sendKeys("Тбилиси, Грузия");
        Thread.sleep(1000);
        direction.sendKeys(Keys.RETURN);

        //Дата заезда
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div[1]/label/div[1]/div")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("/html/body/div[7]/div[1]/div/div[6]/div")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[3]/div[6]/div[5]/div[6]/div")).click();

        //Дата выезда
        Thread.sleep(400);
        driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[3]/div[6]/div[6]/div[1]/div")).click();

        //Работа
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[5]/div/div/label[2]/div/span[1]")).click();
        Thread.sleep(400);

        //Гости
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[3]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]")).click();


        //Найти
        driver.findElement(By.xpath("//*[@id=\":0\"]/div/div/div[1]/div/div[3]/div/div[2]/div/div[4]/button")).click();


        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\":2\"]/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[3]/div/div[2]/div/div[1]")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("//*[@id=\":2\"]/div/div[1]/div/div/div[3]/aside/div[3]/div/div/div[3]/div/div[2]/div/div[2]/div/div/ul/li[2]")).click();
        Thread.sleep(4000);

        driver.quit();

    }


}
