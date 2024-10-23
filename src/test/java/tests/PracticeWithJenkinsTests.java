package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class PracticeWithJenkinsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String firstName = randomUtils.getRandomFirstName();
    String lastName = randomUtils.getRandomLastName();
    String userEmail = randomUtils.getRandomEmail();
    String gender = randomUtils.getRandomGender();
    String phone = randomUtils.getRandomPhone();
    String currentAddress = randomUtils.getRandomAddress();
    String dayOfBirth = randomUtils.getRandomDayOfBirth();
    String monthOfBirth = randomUtils.getRandomMonthOfBirth();
    String yearOfBirth = randomUtils.getRandomYearOfBirth();
    String subjectsInput = randomUtils.getRandomSubject();
    String hobbies = randomUtils.getRandomHobby();
    String foto = randomUtils.getRandomFoto();
    String state = randomUtils.getRandomState();
    String city = randomUtils.getRandomCity(state);


    @Test
    public void successRegistrationWithFullValueForJenkinsTest() {

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

}
