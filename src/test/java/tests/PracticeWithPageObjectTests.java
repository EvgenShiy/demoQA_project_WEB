package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void successRegistrationWithFullValueTest() {

        String firstName = "Bred",
                lastName = "Pit",
                userEmail = "BredPit@example.com",
                gender ="Male",
                phone = "1234567890",
                dayOfBirth = "30", monthOfBirth = "July", yearOfBirth = "1991",
                subjectsInput = "Maths",
                hobbies = "Sports",
                foto = "testfile.png",
                currentAddress = "1234 Main St, Springfield",
                state = "NCR",
                city = "Delhi";


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