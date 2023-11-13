package test;

import data.DataStudentRegistrationForm;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTest extends BaseTest{
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    DataStudentRegistrationForm data = new DataStudentRegistrationForm();

    @Test
    public void successfullyFillRegistrationForm() {
        studentRegistrationFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setDateOfBirth(data.day, data.mouth,data.year)
                .chooseSubject(data.subjectValue)
                .chooseHobbie(data.hobbieValue)
                .uploadPicture(data.pictureName)
                .setAddress(data.address)
                .chooseState(data.stateButton, data.stateName)
                .chooseCity(data.cityButton,data.cityName)
                .clickButton()
                .checkResult(data.key, data.firstName);
    }

    @Test
    public void fillRequiredFields() {
        studentRegistrationFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .clickButton()
                .checkResult(data.key, data.firstName);

    }
    @Test
    public void negativeCheck() {
        studentRegistrationFormPage.openPage()
                .clickButton()
                .requiredFieldNameChangeColor(data.color);
    }




}
