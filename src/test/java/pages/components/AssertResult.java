package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AssertResult {
    public void checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkColorOfField(SelenideElement selector, String value) {
        $(selector).shouldHave(cssValue("color", value));
    }

}
