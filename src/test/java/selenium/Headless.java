package selenium;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class Headless {
    WebDriver driver;
    public Headless() {
      //  driver = new HtmlUnitDriver();
   /*     WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
         driver = new ChromeDriver(options);*/
        driver = new HtmlUnitDriver();

    }

    @Test
    public void handleStaticTable() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        // System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[1]/th[1]")).getText());

        for(int rowno=2;rowno<=4;rowno++)
        {
            for(int colno=1;colno<=3;colno++)
            {
                System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[" + rowno + "]/td[" + colno + "]")).getText());
            }
        }
    }

    @Test
    public void doScroll(){
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        String checkboxText= js.executeScript("return document.getElementById('zone2-entries').innerText;").toString();
        System.out.println(checkboxText);
    }
}
