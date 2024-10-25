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
    @DisplayName("Проверка заполнения полей формы регистрации")
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

}
