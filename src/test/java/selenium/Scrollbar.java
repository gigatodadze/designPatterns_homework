package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scrollbar {
    WebDriver driver;

    public Scrollbar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void handleScrollBar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
       // // This  will scroll down the page by  1000 pixel vertical
        js.executeAsyncScript("window.scrollBy(0,1000)");
     //   WebElement Element = driver.findElement(By.linkText("Linux"));
        //This will scroll the page till the element is found
     //   js.executeScript("arguments[0].scrollIntoView();", Element);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}