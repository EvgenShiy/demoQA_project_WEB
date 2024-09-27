package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; // используется только для отладки тестов (установить значение true)
        Configuration.timeout = 5000; // default 4000
        Configuration.baseUrl = "https://demoqa.com"; // устанавливаем базовый URL
    }
}
