package Tests;

import StepObject.DashboardSteps;
import io.qameta.allure.*;
import org.junit.Assert;
import org.testng.annotations.Test;


public class LoginTest {
    DashboardSteps dashboardSteps;
     public LoginTest(){
          dashboardSteps=new DashboardSteps();
     }

     @Epic("Client registration")
     @Feature("Legal client registration")
     @Story("Non-res legal client registration")
     @Test
    public void successLogin(){
         dashboardSteps.getHeading();
         dashboardSteps.clickLogout();
     }


}
