package ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFromPage extends BasePage {

    private final SelenideElement firstName = $(By.id("firstName"));
    private final SelenideElement lastName = $(By.id("lastName"));
    private final SelenideElement userEmail = $(By.id("userEmail"));
    private final SelenideElement maleGender = $x("//label[normalize-space()='Male']");
    private final SelenideElement femaleGender = $x("//label[normalize-space()='Female']");
    private final SelenideElement otherGender = $x("//label[normalize-space()='Other']");
    private final SelenideElement mobileNumber = $(By.id("userNumber"));
    private final SelenideElement dateOfBirth = $(By.id("dateOfBirthInput"));
    private final SelenideElement dateOfBirthMonth = $(By.className("react-datepicker__month-select"));
    private final SelenideElement dateOfBirthYear = $(By.className("react-datepicker__year-select"));
    private final SelenideElement getDateOfBirthDay = $(By.className("react-datepicker__day--19"));
    private final SelenideElement subjects = $(By.id("subjectsInput"));
    private final SelenideElement subjectsInput = $x("//div[@class='subjects-auto-complete__option css-yt9ioa-option']");


    public void setFirstName(String value) {
        firstName.setValue(value);
    }

    public void setLastName(String value) {
        lastName.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmail.setValue(value);
    }

    public void setMaleGender() {
        maleGender.click();
    }

    public void setFemaleGender() {
        femaleGender.click();
    }

    public void setOtherGender() {
        otherGender.click();
    }

    public void setMobileNumber(String value) {
        mobileNumber.setValue(value);
    }

    public void setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        dateOfBirthMonth.selectOption(month);
        dateOfBirthYear.selectOption(year);
        dateOfBirth.sendKeys(Keys.ENTER);
    }

    public void setSubjects(String value) {
        subjects.click();
        subjects.setValue(value);
        subjectsInput.click();
    }
}
