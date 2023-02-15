package StepDefinitions;

import PageObjects.DatepickerPage;
import io.cucumber.java.en.Then;

public class StepDatepicker {
    DatepickerPage datepickerPage = new DatepickerPage();

    @Then("user input {string} on datepicker")
    public void user_input_on_datepicker(String string) {
        datepickerPage.chooseDate(string);
    }

    @Then("validate background color on date {string}")
    public void validate_background_color_on_date(String string) {
        datepickerPage.validateDate(string);
    }
}
