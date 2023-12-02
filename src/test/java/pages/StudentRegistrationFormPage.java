package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    private String stateButton = "#state";
    private String cityButton = "#city";

    @Step("Открываем страницу формы регистрации")
    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполняем имя")
    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполняем фамилию")
    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Заполняем email")
    public StudentRegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Заполняем пол")
    public StudentRegistrationFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Заполняем мобильный телефон")
    public StudentRegistrationFormPage setMobileNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Заполняем дату рождения")
    public StudentRegistrationFormPage setDateOfBirth(String day, String mouth, String year) {
        calendarInput.click();
        calendar.setDate(day, mouth, year);

        return this;
    }
    @Step("Выбираем subject")
    public StudentRegistrationFormPage chooseSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Выбираем хобби")
    public StudentRegistrationFormPage chooseHobbie(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Загружаем картинку")
    public StudentRegistrationFormPage uploadPicture(String value) {
        loadFied.uploadFromClasspath(value);
        return this;
    }
    @Step("Заполняем адрес")
    public StudentRegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    @Step("Выбираем штат")
    public StudentRegistrationFormPage chooseState(String value) {
        listBox.listboxItem(stateButton, value);
        return this;
    }

    @Step("Выбираем город")
    public StudentRegistrationFormPage chooseCity(String value) {
        listBox.listboxItem(cityButton, value);
        return this;
    }
    @Step("Нажимаем кнопку")
    public StudentRegistrationFormPage clickButton() {
        button.click();
        return this;
    }
    @Step("Проверка результата заполнения формы")
    public StudentRegistrationFormPage checkResult(String key, String value) {
        assertResult.checkResultFilledTable(key, value);
        return this;
    }
    @Step("Негативная проверка. Окно с заполненными данными не отобразилось")
    public void checkTableIsNotAppeared() {
        tableResult.shouldNotBe(Condition.visible);
    }

}
