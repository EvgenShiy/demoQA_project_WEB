package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
        open("https://demoqa.com/automation-practice-form");  // Открываем нужный сайт
    }

    @Test
    public void testFormSubmission() {
        // Заполняем поля имени, фамилии и email
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe@example.com");

        // Выбираем пол (Male)
        $(By.cssSelector("label[for='gender-radio-1']")).scrollTo().click();

        // Вводим номер телефона
        $("#userNumber").setValue("1234567890");

        // Открываем календарь и выбираем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");  // Выбор месяца
        $(".react-datepicker__year-select").selectOption("2024");  // Выбор года
        $(".react-datepicker__day--006").click();  // Выбор 6-го числа

        // Выбираем предмет (например, "Math")
        $("#subjectsInput").setValue("Math").pressEnter();

        // Выбираем хобби (чекбокс)
        $("label[for='hobbies-checkbox-1']").click();


        // Загружаем файл
        String filePath = "src/test/resources/testfile.png";
        $("#uploadPicture").uploadFile(new File(filePath));


        // Вводим адрес
        $("#currentAddress").setValue("1234 Main St, Springfield");

        // Выбираем значение из дропдауна (State, City)
        $("#react-select-3-input").setValue("NCR").pressEnter();  // Выбор штата
        $("#react-select-4-input").setValue("Delhi").pressEnter();  // Выбор города

        // Нажимаем на кнопку Submit
        $("#submit").click();

        // Проверяем текст в модальном окне после отправки формы
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        // Проверяем значения в модальном окне используя CSS селекторы
        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
                .shouldHave(text("John Doe"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(2) > td:nth-child(2)")
                .shouldHave(text("johndoe@example.com"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(3) > td:nth-child(2)")
                .shouldHave(text("Male"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(4) > td:nth-child(2)")
                .shouldHave(text("1234567890"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(5) > td:nth-child(2)")
                .shouldHave(text("06 September,2024"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(6) > td:nth-child(2)")
                .shouldHave(text("Maths"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(7) > td:nth-child(2)")
                .shouldHave(text("Sports"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(8) > td:nth-child(2)")
                .shouldHave(text("testfile.png"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(9) > td:nth-child(2)")
                .shouldHave(text("1234 Main St, Springfield"));

        $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody > tr:nth-child(10) > td:nth-child(2)")
                .shouldHave(text("NCR Delhi"));

                // Нажимаем на кнопку Close, чтобы закрыть модальное окно
        $(By.cssSelector("#closeLargeModal")).scrollTo().click();

    }
}
