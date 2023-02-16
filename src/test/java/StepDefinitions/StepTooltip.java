package StepDefinitions;

import PageObjects.TooltipPage;
import io.cucumber.java.en.Then;

public class StepTooltip {
    TooltipPage tooltipPage = new TooltipPage();

    @Then("user hover to textbox")
    public void user_hover_to_textbox() {
        tooltipPage.hover();
    }

    @Then("validate the text inside tooltip as {string}")
    public void validate_the_text_inside_tooltip_as(String string) {
        tooltipPage.validate(string);
    }
}
