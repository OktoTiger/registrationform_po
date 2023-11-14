package pages.components;

import static com.codeborne.selenide.Selenide.$;


public class Calendar {
    public void setDate(String day, String mouth, String year) {
        $(".react-datepicker__month-select").selectOption(mouth);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",day)).click();
    }
}
