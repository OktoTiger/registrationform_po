package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.AssertResult;
import pages.components.Calendar;
import pages.components.Date;
import pages.components.ListBox;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage extends Date {

    Calendar calendar =new Calendar();
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
            button = $("#submit");

    public String
//            pictureName = "photo_cat.jpg",
//                day = "17",
//                mouth = "June",
//                year = "2001",
//                stateButton = "#state",
//                stateName = "NCR",
//                cityButton = "#city",
//                cityName ="Delhi",
                color = "rgba(73, 80, 87, 1)";




    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public StudentRegistrationFormPage setFirstName() {
        firstNameInput.setValue(name);
        return this;
    }

    public StudentRegistrationFormPage setLastName() {
        lastNameInput.setValue(lastName);

        return this;
    }

    public StudentRegistrationFormPage setEmail() {
        userEmailInput.setValue(email);
        return this;
    }

    public StudentRegistrationFormPage setGender() {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public StudentRegistrationFormPage setMobileNumber() {
        userNumberInput.setValue(mobileNumber);
        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth() {
        calendarInput.click();
        calendar.setDate(this.day, this.mouth, this.year);

        return this;
    }

    public StudentRegistrationFormPage chooseSubject() {
        subjectInput.setValue(subjectValue).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage chooseHobbie() {
        hobbiesWrapper.$(byText(hobbieValue)).click();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture() {
        loadFied.uploadFromClasspath(pictureName);
        return this;
    }

    public StudentRegistrationFormPage setAddress() {
        addressInput.setValue(address);
        return this;
    }


    public StudentRegistrationFormPage chooseState() {
        listBox.listboxItem(this.stateButton, stateName);
        return this;
    }


    public StudentRegistrationFormPage chooseCity() {
        listBox.listboxItem(this.cityButton, cityName);
        return this;
    }

    public StudentRegistrationFormPage clickButton() {
        button.click();
        return this;
    }

    public StudentRegistrationFormPage checkResult() {
        assertResult.checkResult(key, value);
        return this;
    }

    public StudentRegistrationFormPage requiredFieldNameChangeColorToRed() {
        $(firstNameInput).shouldHave(cssValue("color", color));
        return this;
    }

}
