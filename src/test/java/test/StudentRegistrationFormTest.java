package test;

import data.DataStudentRegistrationForm;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTest extends BaseTest {
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
                .setDateOfBirth(data.day, data.mouth, data.year)
                .chooseSubject(data.subjectValue)
                .chooseHobbie(data.hobbieValue)
                .uploadPicture(data.pictureName)
                .setAddress(data.address)
                .chooseState(data.stateButton, data.stateName)
                .chooseCity(data.cityButton, data.cityName)
                .clickButton()
                .checkResult(data.keyMassive[0], String.format("%s %s", data.firstName, data.lastName))
                .checkResult(data.keyMassive[1], data.email)
                .checkResult(data.keyMassive[2], data.gender)
                .checkResult(data.keyMassive[3], data.mobileNumber)
                .checkResult(data.keyMassive[4], String.format("%s %s,%s", data.day, data.mouth, data.year))
                .checkResult(data.keyMassive[5], data.subjectValue)
                .checkResult(data.keyMassive[6], data.hobbieValue)
                .checkResult(data.keyMassive[7], data.pictureName)
                .checkResult(data.keyMassive[8], data.address)
                .checkResult(data.keyMassive[9], String.format("%s %s", data.stateName, data.cityName));
    }

    @Test
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
    public void negativeCheck() {
        studentRegistrationFormPage.openPage()
                .clickButton()
                .checkTableIsNotAppeared();
    }


}
