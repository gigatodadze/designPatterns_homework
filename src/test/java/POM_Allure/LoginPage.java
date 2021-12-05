package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseTest{
    By uName = By.id("userName");
    By pswd = By.id("password");
    By loginBtn = By.id("login");


    @Step("Login with userName {0}")
    public void enterUsername(String user) {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.findElement(uName).sendKeys(user);

    }

    @Step("Login with password {0}")
    public void enterPassword(String pass) {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.findElement(pswd).sendKeys(pass);
    }

    @Step
    public void clickLogin() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.findElement(loginBtn).click();
    }
}
