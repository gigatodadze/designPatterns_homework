package StepObject;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.reopenBrowserOnFail;

public class ConfigSteps {

    public ConfigSteps(){
        startMaximized=true;
        holdBrowserOpen=false;
        reopenBrowserOnFail = true;
    }
}
