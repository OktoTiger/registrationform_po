package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.AssertResult;
import pages.components.Calendar;
import pages.components.ListBox;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormPage {

    Calendar calendar = new Calendar();
    ListBox listBox = new ListBox();
    AssertResult assertResult = new AssertResult();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            loadFied = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            button = $("#submit"),
            tableResult = $("table");


    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage setMobileNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String mouth, String year) {
        calendarInput.click();
        calendar.setDate(day, mouth, year);

        return this;
    }

    public StudentRegistrationFormPage chooseSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage chooseHobbie(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String value) {
        loadFied.uploadFromClasspath(value);
        return this;
    }

    public StudentRegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }


    public StudentRegistrationFormPage chooseState(String button, String value) {
        listBox.listboxItem(button, value);
        return this;
    }


    public StudentRegistrationFormPage chooseCity(String button, String value) {
        listBox.listboxItem(button, value);
        return this;
    }

    public StudentRegistrationFormPage clickButton() {
        button.click();
        return this;
    }

    public StudentRegistrationFormPage checkResult(String key, String value) {
        assertResult.checkResultFilledTable(key, value);
        return this;
    }


    public void checkTableIsNotAppeared() {
        tableResult.shouldNotBe(Condition.visible);
    }

}
