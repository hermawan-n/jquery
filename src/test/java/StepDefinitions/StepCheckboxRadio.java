package StepDefinitions;

import PageObjects.CheckboxradioPage;
import io.cucumber.java.en.Then;

public class StepCheckboxRadio {
    CheckboxradioPage checkboxradioPage = new CheckboxradioPage();

    @Then("user choose {string} on checkboxradio {string}")
    public void user_choose_on_checkboxradio(String string, String string2) {
        checkboxradioPage.selectChecboxRadio(string, string2);
    }

    @Then("validate color of {string} on checkbox {string} is {string}")
    public void validate_color_of_on_checkbox_is(String string, String string2, String string3) {
        checkboxradioPage.validateCheckboxradio(string, string2, string3);
    }
}
