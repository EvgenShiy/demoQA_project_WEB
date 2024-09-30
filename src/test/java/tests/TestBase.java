package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager"; // Оптимизация загрузки страницы
        Configuration.holdBrowserOpen = false;    // Использовать true для отладки
        Configuration.baseUrl = "https://demoqa.com"; // Базовый URL
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();  // Закрытие браузера после каждого теста
    }
}
