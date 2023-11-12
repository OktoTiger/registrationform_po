package test;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTest extends BaseTest{
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    public void successfullyFillRegistrationForm() {
        studentRegistrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setMobileNumber()
                .setDateOfBirth()
                .chooseSubject()
                .chooseHobbie()
                .uploadPicture()
                .setAddress()
                .chooseState()
                .chooseCity()
                .clickButton()
                .checkResult();
    }

    @Test
    public void fillRequiredFields() {
        studentRegistrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setGender()
                .setMobileNumber()
                .clickButton()
                .checkResult();

    }
    @Test
    public void negativeCheck() {
        studentRegistrationFormPage.openPage()
                .clickButton()
                .requiredFieldNameChangeColorToRed();
    }




}
