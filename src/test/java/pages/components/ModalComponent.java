package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    public void checkResult(String key, String value) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }


    public void negativeCheck() {
        $("form#userForm").shouldHave(attribute("class", "was-validated"));
    }
}
