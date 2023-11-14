package pages.components;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ListBox {
    public void listboxItem(String buttonLocator, String location) {
        $(buttonLocator).click();
        $("#stateCity-wrapper").$(byText(location)).click();
    }
}
