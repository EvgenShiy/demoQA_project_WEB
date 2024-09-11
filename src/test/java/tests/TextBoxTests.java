package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false; // используется только для отладки тестов (установить значение true)
        Configuration.timeout = 5000; // default 4000
        Configuration.baseUrl = "https://demoqa.com"; // устанавливаем базовый URL
    }

    @Test
    public void formSubmissionTest() {
        open("/automation-practice-form"); // относительный путь

        // Удаляем баннер и футер через JavaScript
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");

        // Заполняем поля имени, фамилии и email
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe@example.com");

        // Выбираем пол (Male)
        $("[for='gender-radio-1']").click();

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
        //String filePath = "src/test/resources/testfile.png";
        //$("#uploadPicture").uploadFile(new File(filePath));
        $("#uploadPicture").uploadFromClasspath("testfile.png");


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
        $(".table-responsive tbody tr:nth-child(1) td:nth-child(2)")
                .shouldHave(text("John Doe"));


        $(".table-responsive tbody tr:nth-child(2) td:nth-child(2)")
                .shouldHave(text("johndoe@example.com"));

        $(".table-responsive tbody tr:nth-child(3) td:nth-child(2)")
                .shouldHave(text("Male"));

        $(".table-responsive tbody tr:nth-child(4) td:nth-child(2)")
                .shouldHave(text("1234567890"));

        $(".table-responsive tbody tr:nth-child(5) td:nth-child(2)")
                .shouldHave(text("06 September,2024"));

        $(".table-responsive tbody tr:nth-child(6) td:nth-child(2)")
                .shouldHave(text("Maths"));

        $(".table-responsive tbody tr:nth-child(7) td:nth-child(2)")
                .shouldHave(text("Sports"));

        $(".table-responsive tbody tr:nth-child(8) td:nth-child(2)")
                .shouldHave(text("testfile.png"));

        $(".table-responsive tbody tr:nth-child(9) td:nth-child(2)")
                .shouldHave(text("1234 Main St, Springfield"));

        $(".table-responsive tbody tr:nth-child(10) td:nth-child(2)")
                .shouldHave(text("NCR Delhi"));

        // Нажимаем на кнопку Close, чтобы закрыть модальное окно
        $(By.cssSelector("#closeLargeModal")).scrollTo().click();

    }
}
