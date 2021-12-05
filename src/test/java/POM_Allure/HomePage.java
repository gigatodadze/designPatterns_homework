package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseTest {

    By LoginBtn = By.id("login");

    @Step
    public void clickLogin() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.findElement(LoginBtn).click();
    }
}
