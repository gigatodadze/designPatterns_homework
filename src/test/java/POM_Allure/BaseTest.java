package POM_Allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BaseTest {

    WebDriver driver;

    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}