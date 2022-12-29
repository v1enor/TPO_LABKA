import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hello_world {
    public static void main(String[] args) throws InterruptedException {
        BringItOn();

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
    @Test
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




}
