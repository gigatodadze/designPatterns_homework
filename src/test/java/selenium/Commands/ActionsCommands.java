package selenium.Commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsCommands {
    @Test
    public void holdAndRelease() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Actions");
        driver.manage().window().maximize();

        WebElement element_1= driver.findElement(By.name("one"));
        WebElement element_12= driver.findElement(By.name("eleven"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element_1).clickAndHold().moveToElement(element_12).release().perform();
        List<WebElement> list=driver.findElements(By.id("selectable"));
        System.out.println(list.size());
       // actions.clickAndHold(element_1).release(element_12).build().perform();
    }
    @Test
    public void contextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        driver.manage().window().maximize();

        WebElement element= driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        actions
                .contextClick(element)
                .perform();

    }
    @Test
    public void dragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Actions");
        driver.manage().window().maximize();

        WebElement element_draggable= driver.findElement(By.id("draggable"));
        WebElement element_droppable= driver.findElement(By.id("droppable"));

        int x=element_droppable.getLocation().getX();
        int y=element_droppable.getLocation().getY();
        Actions actions = new Actions(driver);
       actions.dragAndDrop(element_draggable,element_droppable).build().perform();

      //  actions.dragAndDropBy(element_draggable,x,y).build().perform();
    }
    @Test
    public void doKeyPresses() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();


        WebElement element= driver.findElement(By.id("target"));
        element.sendKeys(Keys.CONTROL);
    }



}
