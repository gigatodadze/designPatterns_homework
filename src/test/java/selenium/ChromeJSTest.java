package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class ChromeJSTest {

    private WebDriver driver;

  public ChromeJSTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    @Test
    public void testSelenium() {
        driver.get("https://experitest.com");
        WebElement footer = driver.findElement(By.className("book-demo-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    @Test
    public void locateElement() {
        driver.get("https://experitest.com");
        WebElement startButton = (WebElement) ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13];");
    }

    @Test
    public void clickElement1() {
        driver.get("https://experitest.com");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13].click();");
    }

    @Test
    public void printAlert() {
        driver.get("https://experitest.com");
        ((JavascriptExecutor) driver).executeScript("alert('Welcome to Experitest');");
    }

    @Test
    public void scrollToElement() {
        driver.get("https://experitest.com");
        WebElement footerBtn = driver.findElement(By.className("book-demo-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerBtn);
    }

    @Test
    public void changeStyle() {
        driver.get("https://experitest.com");
        WebElement footer = driver.findElement(By.className("book-demo-btn"));
        ((JavascriptExecutor) driver).executeScript("document.getElementById('to-about-section').style.border = '100px dotted blue'");
    }

    @Test
    public void implementWaits() {
        driver.get("https://experitest.com");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.location = 'https://www.softwaretestingmaterial.com'");


    }
}