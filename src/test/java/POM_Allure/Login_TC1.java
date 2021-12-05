package POM_Allure;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(Config.class)
@Epic("Regression Tests")
@Feature("Login Tests")
public class Login_TC1 extends BaseTest{
@BeforeTest
public void setup(){
    BaseTest baseTest=new BaseTest();
    baseTest.initialize();
//    System.setProperty("webdriver.chrome.driver", "chromedriver96");
//    WebDriver driver = new ChromeDriver();

}

    @Flaky
    @Test(description = "Login and Logout Scenario")
    @Description("Success login and logout scenario")
    @Story("Valid username and password login test")
    public void openForms(){

//        WebElement element= driver.findElement(By.className("card-body")));
//        WebElement element = driver.findElement(By.className("card-body"));
//        WebElement elementementForm= driver.findElement(By.cssSelector("[class^=category-cards]:nth-child(2)"));

//        elementForm.click();


        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        Dashboard dashboard = new Dashboard();
        home.clickLogin();
        login.enterUsername("alina23");
        login.enterPassword("Automation!1");
        login.clickLogin();
        dashboard.checkText();
        dashboard.clickLogout();

    }
    @Flaky
    @Test(description = "Login and Logout Scenario")
    @Description("Success login and logout scenario")
  //  @Story("InvaliValid username and password login test")
    public void invalidLogin(){

        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        Dashboard dashboard = new Dashboard();
        home.clickLogin();
        login.enterUsername("alina23");
        login.enterPassword("Automation");
        login.clickLogin();
        dashboard.checkText();
        dashboard.clickLogout();

    }

}
