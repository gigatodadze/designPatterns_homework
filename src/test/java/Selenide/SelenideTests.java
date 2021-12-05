package Selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.FileDownloadMode.HTTPGET;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTests {

    public SelenideTests(){
  /*     System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\MicrosoftWebDriver.exe");
        WebDriverRunner.setWebDriver(new EdgeDriver());
        browser= Browsers.CHROME;*/
        startMaximized=true;
        holdBrowserOpen=false;
        baseUrl = "http://the-internet.herokuapp.com";
        reopenBrowserOnFail = true;

       screenshots=true;
        Configuration.fileDownload = HTTPGET;
        reportsFolder="C:\\Users\\Admin\\Desktop\\TestAutomationProject\\screenshots";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));



    }

    @Test
    @Flaky
    public void useInnerElements(){
        open("http://techcanvass.com/Examples/webtable.html");
        //$("#header").find("#menu").findAll(".item")
        $("#t01").find("tbody").findAll("tr").get(0).findAll("th").get(0).shouldHave(text("Company Name"));
       // $ / find()
      // $$ / findAll()
        //$x("//table[@id='t01']/tbody/tr[1]/th[1]").shouldHave(text("cmp"));
    }
    @Test
    public void fileDownload() throws FileNotFoundException {
        open("/download");
        $(byText("not_empty.txt")).download();
        sleep(5000);
    }
    @Test
    public void isImage() {
        open("https://demoqa.com/books");
        $(".rt-td img").isImage();
        sleep(5000);
    }

    @Test
    public void waitForElement() {
        open("/dynamic_loading/1");
        $(byText("Start")).click();

        //$("#finish h4").shouldHave(text("Hell World"));
        Assert.assertEquals( $("#finish h4").getText(),"Hell World");

       // $("#finish h4").waitUntil(visible,10000).getText();

    }

    @Test(description = "Add and Remove Elements",enabled=false)
    @Description("Additional description")
    public void doAction(){
        open("/add_remove_elements/");
       // $(byText("Delete")).click();
        for (int i = 0; i <3 ; i++) {
            $(byText("Add Element")).click();
        }
        $$(byText("Delete")).shouldHave(texts("Delete","Delete","Add"));
        $(byText("Delete")).click();
      //  System.out.println($("body").find("#elements").findAll(".added-manually").get(0).getText());
        sleep(4000);
    }
    @Test(enabled=false)
    public void fillInputs(){
      $(byAttribute("type","number")).setValue("1");
        $(byAttribute("type","number")).shouldHave(value("5"));
        sleep(4000);
    }
    @Test
    public void handleCheckbox(){
        open("/checkboxes");
       // $$("#checkboxes input").stream().forEach(el -> { el.shouldHave(type("checkbox"));});
        //Assert.assertEquals($("#checkboxes input").isDisplayed(),true);
        Assert.assertTrue($("#checkboxes input").isDisplayed());
        $("#checkboxes input").shouldBe(Condition.appear);
        sleep(4000);
    }
    @Test(enabled=false)
    public void handleDropDowns(){
        open("/dropdown");
       $("#dropdown").getSelectedOption().shouldHave(matchText("Option 1"),value("1"));
        $("#dropdown").selectOptionContainingText("Option 1");
         $("#dropdown").getSelectedOption().shouldHave(matchText("ption 1"),value("1"));
    }

    @AfterClass
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
