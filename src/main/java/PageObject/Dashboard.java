package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
    WebDriver driver;
    public WebElement heading = driver.findElement(By.xpath("//div[@class=\"main-header\"]")),
    logoutBtn = driver.findElement(By.id("submit"));
}
