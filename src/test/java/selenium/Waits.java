package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Waits {
    WebDriver driver;

    public Waits() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void waitImplicitly() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        WebElement submitButton = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));
        submitButton.click();
        WebElement message=driver.findElement(By.id("message"));
        System.out.println(message);
        System.out.println(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());
    }

    @Test
    public void waitExplicitly() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Example1: Element on page that is hidden']")).click();
        driver.findElement(By.xpath("//div[@id='start']//following-sibling::button")).click();
        WebElement text = driver.findElement(By.xpath("//div[@id='finish']//following::h4"));

        new WebDriverWait(driver, 8).until(ExpectedConditions.visibilityOf(text));
        System.out.println(text.getText());
    }
    @Test
    public void progressBar() {
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(By.id("startStopButton")).click();
      // driver.findElement(By.xpath("//button[text()='100%']"));
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='100%']")));
        System.out.println(driver.findElement(By.xpath("//div[text()='100%']")).getText());

    }
    @Test
    public void dropDowns() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        List<WebElement> name = driver.findElements(By.xpath("//div[@id='checkboxes']/label"));
        for(WebElement selectedOption : name) {
            selectedOption.click();
        }

    }

    public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value){
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    public static void clickOn(WebDriver driver1, WebElement element, int timeout){
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @AfterMethod
    public void tearDown(){
         //   driver.close();
    }
}
