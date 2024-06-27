package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.common.CommonActions;

public class BaseTest {


    private String URL = "https://demoqa.com/automation-practice-form";

    @BeforeEach
    void open() {
        CommonActions.openBrowser();
        Selenide.open(URL);
    }
}
