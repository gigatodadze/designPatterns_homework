package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UserRegister {
    @DataProvider
    public static Object[][] userData() {
        return new Object[][] {{"Giga","Todadze","Male","0558313933"},{"Mariam","Todadze","Female","0555199393"} };
    }
    @Test(dataProvider = "userData",description = "Register New Student Scenario")
    public void fillForms(String firstName,String lastName,String gender,String userNumber) {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        WebElement elementForm = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        if(elementForm.getText().equals("Forms")){
            elementForm.click();
        }

        WebElement PracticeForm = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span"));
//        System.out.println(PracticeForm.getText());
//        WebElement element = w.waitUntil(ExpectedConditions.elementToBeClickable(by);

        PracticeForm.click();
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);
        if (gender.equals("Male")) {
            WebElement genderField = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]"));
            genderField.click();
        }
        else if(gender.equals("Female")){
            WebElement genderField = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]"));
            genderField.click();
        }
        else {
            WebElement genderField = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]"));
            genderField.click();
        }

        WebElement userNumberField = driver.findElement(By.id("userNumber"));
        userNumberField.sendKeys(userNumber);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));

//        System.out.println(submitButton.getText());

        submitButton.submit();
//        submitButton.click();

        WebElement ThankYouText = driver.findElement(By.id("example-modal-sizes-title-lg"));

        if (ThankYouText.getText().equals("Thanks for submitting the form")){
            System.out.println("Thank you message is visible");
        }

        WebElement tablenameSurname = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"));
        if(tablenameSurname.getText().equals(firstName+" "+lastName)){
            System.out.println("Name and Surname is correct");
        }

        WebElement tableGender = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]"));
        if(tableGender.getText().equals(gender)){
            System.out.println("Gender is correct");
        }
        WebElement tableNumber = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]"));
        if(tableNumber.getText().equals(userNumber)){
            System.out.println("Number is correct");
        }
    }
}
