package POM_Allure;

import io.qameta.allure.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@Listeners(Config.class)
@Epic("Fill Form Epic Tests")
@Feature("FillForm Tests")
public class Login_TC1 extends BaseTest {

    @BeforeTest
    public void setup() {
        initialize();
    }

//    public Login_TC1(WebDriver driver) {
//        this.driver = driver;
//    }

    @DataProvider
    public static Object[][] userData() {
        return new Object[][] {{"Giga","Todadze","Male","0558313933"},{"Mariam","Todadze","Female","0555199393"} };
    }

    @Test(description = "Register New Student Scenario")
    public void login(){
        UserRegister userRegister = new UserRegister();
        Object[][] myData = userData();
        for (int i = 0; i <= myData.length; i++) {
        userRegister.fillForms(myData[i][0].toString(),myData[i][1].toString(),myData[i][2].toString(),myData[i][3].toString());
     }
    }

//    @Test(description = "Check New Student Scenario")
//    public void check(){
//        UserRegister userRegister = new UserRegister();
//        Object[][] myData = userData();
//        for (int i = 0; i <= myData.length; i++) {
//            userRegister.CheckForms(myData[i][0].toString(),myData[i][1].toString(),myData[i][2].toString(),myData[i][3].toString());
//        }
//    }


}
