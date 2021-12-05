package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Exceptions {
    WebDriver driver;
    public Exceptions(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
}

   @Test
    public void handleExceptions(){
       driver.get("https://demoqa.com/alerts");
       driver.manage().window().maximize();
       driver.findElement(By.id("timerAlertButton")).click();
       new WebDriverWait(driver,4).until(ExpectedConditions.alertIsPresent());
       driver.quit();
       driver.switchTo().alert().accept();

    }
}
