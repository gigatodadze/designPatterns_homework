package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AssertionTests {
    @Test
    public void softAssertText() {
        open("http://the-internet.herokuapp.com/add_remove_elements/");
        SoftAssert softassert = new SoftAssert();
        $(".example button").click();
        softassert.assertEquals($(".added-manually").getText(), "Add");
        $(".example button").click();
        softassert.assertEquals($(".added-manually").getText(), "Delete");

        softassert.assertAll();
    }
    @Test
    public void softAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail("Failing first assertion");
        System.out.println("Failing 1");
        softAssert.fail("Failing second assertion");
        System.out.println("Failing 2");
        softAssert.assertEquals(1, 1, "Passing third assertion");
        System.out.println("Passing 3");
        softAssert.assertAll();


    }
    @Test
    public void doSeveralAsserts() {
        open("http://the-internet.herokuapp.com/add_remove_elements/");
        $(".example button").click();
       // assertEquals($(".added-manually").isDisplayed(),true,"button is displayed");
        assertTrue($(".added-manually").isDisplayed());

      //  assertFalse($(".added-manually").isDisplayed());
      //  assertNotEquals($(".added-manually").getText(),"Add");
       // $(".added-manually").shouldHave(text("Delete"));
        //  ($(".added-manually").getText(), "Add");

    }
}
