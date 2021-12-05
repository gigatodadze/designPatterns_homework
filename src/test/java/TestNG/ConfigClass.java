package TestNG;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Configuration.*;

public class ConfigClass {
    @BeforeTest
    public void setConfigs(){
        holdBrowserOpen=false;
        baseUrl = "http://the-internet.herokuapp.com";
        System.out.println("Before test");
    }
    @BeforeMethod
    public void setAdditionalConfig(){
        startMaximized=true;
        System.out.println("Before method");
    }
    @AfterMethod
    public void setTearDown(){
        Selenide.closeWebDriver();
        System.out.println("after method");
    }
}
