package ui.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonActions {

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "none";
        Selenide.open();
    }

    public static void openBrowser() {
        setDriver();
    }

}

