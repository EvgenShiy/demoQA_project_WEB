package tests;

import helpers.Attach;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PracticeWithJenkinsTests extends TestBase {


    @Test
    @Tag("demoqa")
    @Owner("shiianovaen")
    @DisplayName("Проверка заполнения всех полей формы регистрации")
    public void successRegistrationWithFullValueForJenkinsTest() {

        WebSteps steps = new WebSteps();

        steps.openStudentRegistrationForm();
        steps.setFirstName();
        steps.setLastName();
        steps.setUserEmail();
        steps.setGender();
        steps.setUserNumber();
        steps.setDateOfBirth();
        steps.setSubjectsInput();
        steps.setHobbies();
        steps.uploadPicture();
        steps.setCurrentAddress();
        steps.setState();
        steps.setCity();
        steps.pressSubmitButton();

        steps.checkResultStudentName();
        steps.checkResultStudentEmail();
        steps.checkResultGender();
        steps.checkResultMobile();
        steps.checkResultDateOfBirth();
        steps.checkResultSubjects();
        steps.checkResultHobbies();
        steps.checkResultPicture();
        steps.checkResultStateAndCity();

        Attach.addVideo();

    }

    @Test
    @Tag("demoqa")
    @Owner("shiianovaen")
    @DisplayName("Проверка только обязательных полей формы регистрации")
    public void successRegistrationWithMinimumValueForJenkinsTest() {

        WebSteps steps = new WebSteps();

        steps.openStudentRegistrationForm();
        steps.setFirstName();
        steps.setLastName();
        steps.setGender();
        steps.setUserNumber();
        steps.pressSubmitButton();

        steps.checkResultStudentName();
        steps.checkResultGender();
        steps.checkResultMobile();
    }

    @Test
    @Tag("demoqa")
    @Owner("shiianovaen")
    @DisplayName("Проверка подсветки заполнения обязательных полей формы регистрации")
    public void requiredFieldsHighlightOnSubmitForJenkinsTest() {

        WebSteps steps = new WebSteps();

        steps.openStudentRegistrationForm();
        steps.pressSubmitButton();

        steps.checkEmptyRequiredFields();
    }

}
