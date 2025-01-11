package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigRunner;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {


    @BeforeAll
    public static void setUp() {

        Configuration.holdBrowserOpen = true;    // Использовать true для отладки
        Configuration.baseUrl = "https://demoqa.com";

        new ConfigRunner();
    }

    @BeforeEach
    public void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Последний скриншот");
        if (!Configuration.browser.equals("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
