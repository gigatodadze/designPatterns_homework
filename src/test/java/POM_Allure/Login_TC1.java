package POM_Allure;

import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Config.class)
@Epic("Regression Tests")
@Feature("Login Tests")
public class Login_TC1 extends BaseTest{
@BeforeTest
public void setup(){
    BaseTest baseTest=new BaseTest();
    baseTest.initialize();
    driver=getDriver();
    driver.get("https://www.demoqa.com/books");

}

    @Flaky
    @Test(description = "Login and Logout Scenario")
    @Description("Success login and logout scenario")
    @Story("Valid username and password login test")
    public void login(){

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
