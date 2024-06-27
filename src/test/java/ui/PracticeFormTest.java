package ui;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ui.pages.PracticeFromPage;

public class PracticeFormTest extends BaseTest {

    PracticeFromPage p = new PracticeFromPage();

    @Test
    void practiceFormPositiveTest() {
        p.setFirstName("Sergey");
        p.setLastName("Romanov");
        p.setUserEmail("skreet_173@mail.ru");
        p.setMaleGender();
        p.setMobileNumber("9773640040");
        p.setSubjects("Computer Science");
        Selenide.sleep(30000);
    }

}
