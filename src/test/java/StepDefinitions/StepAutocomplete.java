package StepDefinitions;

import PageObjects.AutocompletePage;
import io.cucumber.java.en.Then;

public class StepAutocomplete {
    AutocompletePage autocompletePage = new AutocompletePage();

    @Then("user type tags text box as {string}")
    public void user_type_tags_text_box_as(String string) {
        autocompletePage.typeText(string);
    }

    @Then("user hover on {string} suggestion then clicks on it")
    public void user_hover_on_suggestion_then_clicks_on_it(String string) {
        autocompletePage.hoverAndValidate(string);
    }

    @Then("validate inside tags text box has {string}")
    public void validate_inside_tags_text_box_has(String string) {
        autocompletePage.validateInput(string);
    }
}
