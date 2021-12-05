package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ajax {
    WebDriver driver;
    WebDriverWait wait;

    public Ajax() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void handleAjax() {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/social-icon.html");
        By container = By.cssSelector(".container");
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(container));


        WebElement noTextElement = driver.findElement(By.className("radiobutton"));
        String textBefore = noTextElement.getText().trim();

        //Click on the radio button
        driver.findElement(By.id("yes")).click();

        //Click on Check Button
        driver.findElement(By.id("buttoncheck")).click();

        /*Get the text after ajax call*/
        WebElement TextElement = driver.findElement(By.className("radiobutton"));
        wait.until(ExpectedConditions.visibilityOf(TextElement));
        String textAfter = TextElement.getText().trim();

        /*Verify both texts before ajax call and after ajax call text.*/
        Assert.assertNotEquals(textBefore, textAfter);


        String expectedText = "Radio button is checked and it's value is Yes";


        Assert.assertEquals(textAfter, expectedText);
        driver.close();
    }
}
