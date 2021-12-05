package TestNG;

import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestClass extends ConfigClass {
    @Test(threadPoolSize =2,invocationCount=2,timeOut=10000 )
    public void testMethod(){
        open("/abtest");
        System.out.println($(".example h3").getText());
    }
    @Test
    public void testMethod2(){
        open("/add_remove_elements/");
        $(".example button").click();
    }
}
