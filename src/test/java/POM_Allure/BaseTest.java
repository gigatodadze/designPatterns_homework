package POM_Allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {


    static WebDriver driver;

    public void initialize(){
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        WebElement elementForm = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        if(elementForm.getText().equals("Forms")){
            elementForm.click();
        }

        WebElement PracticeForm = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span"));
        System.out.println(PracticeForm.getText());
//        WebElement element = w.waitUntil(ExpectedConditions.elementToBeClickable(by);

        PracticeForm.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Giga");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Todadze");
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]"));
        gender.click();
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("+558313933");


    }
    public static WebDriver getDriver() {
        return driver;
    }
}