package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class PracticeWithRandomUtilsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String userEmail = getRandomEmail();
    String gender = RandomUtils.getRandomGender();
    String phone = getRandomPhone();
    String currentAddress = getRandomAddress();
    String dayOfBirth = getRandomBirthday();
    String subjectsInput = getRandomSubject();
    String hobbies = getRandomHobby();
    String foto = getRandomFoto();
    String state = getRandomState();
    String city = getRandomCity();


    @Test
    public void successRegistrationWithFullValueTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(subjectsInput)
                .setHobbies(hobbies)
                .uploadPicture(foto)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmitButton();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", foto)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    public void successRegistrationWithMinimumValueTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .pressSubmitButton();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone);
    }

    @Test
    public void requiredFieldsHighlightOnSubmitTest() {

        registrationPage.openPage()
                .pressSubmitButton();

        registrationPage.negativeCheck();
    }
}