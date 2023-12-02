package test;

import data.DataStudentRegistrationForm;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTest extends BaseTest {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    DataStudentRegistrationForm data = new DataStudentRegistrationForm();

    @Test
    @Tag("smoke")
    @Feature("Регистрация студента")
    @Story("Заполнение формы регистрации студента")
    @Owner("Dmitry Nazarov")
    @Link(value = "Student Registration Form",
            url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Успешное заполнение всех полей формы регистрации студента")
    public void successfullyFillRegistrationForm() {
        studentRegistrationFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .chooseSubject(data.subjectValue)
                .chooseHobbie(data.hobbieValue)
                .uploadPicture(data.pictureName)
                .setAddress(data.address)
                .chooseState(data.stateName)
                .chooseCity(data.cityName)
                .clickButton()
                .checkResult(data.keyMassive[0], String.format("%s %s", data.firstName, data.lastName))
                .checkResult(data.keyMassive[1], data.email)
                .checkResult(data.keyMassive[2], data.gender)
                .checkResult(data.keyMassive[3], data.mobileNumber)
                .checkResult(data.keyMassive[4], String.format("%s %s,%s", data.day, data.month, data.year))
                .checkResult(data.keyMassive[5], data.subjectValue)
                .checkResult(data.keyMassive[6], data.hobbieValue)
                .checkResult(data.keyMassive[7], data.pictureName)
                .checkResult(data.keyMassive[8], data.address)
                .checkResult(data.keyMassive[9], String.format("%s %s", data.stateName, data.cityName));
    }


    @Test
    @Tag("smoke")
    @Feature("Регистрация студента")
    @Story("Заполнение формы регистрации студента")
    @Owner("Dmitry Nazarov")
    @Link(value = "Student Registration Form",
            url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Успешное заполнение обязательных полей формы регистрации студента")
    public void fillRequiredFields() {
        studentRegistrationFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .clickButton()
                .checkResult(data.keyMassive[0], String.format("%s %s", data.firstName, data.lastName))
                .checkResult(data.keyMassive[2], data.gender)
                .checkResult(data.keyMassive[3], data.mobileNumber);

    }

    @Test
    @Feature("Регистрация студента")
    @Story("Заполнение формы регистрации студента")
    @Owner("Dmitry Nazarov")
    @Link(value = "Student Registration Form",
            url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативная проверка.Не заполнены обязательные поля " +
            "на форме регистрации студента")
    public void negativeCheck() {
        studentRegistrationFormPage.openPage()
                .clickButton()
                .checkTableIsNotAppeared();
    }


}
