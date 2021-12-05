package StepObject;

import PageObject.Dashboard;
import com.codeborne.selenide.AssertionMode;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DashboardSteps {
    WebDriver driver;
    Dashboard dashboard=new Dashboard();

    @Step
    public String getHeading() {

        return dashboard.heading.getText();
    }

    public void clickLogout() {
        dashboard.logoutBtn.click();
    }
}
