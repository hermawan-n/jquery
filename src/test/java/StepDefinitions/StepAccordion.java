package StepDefinitions;

import PageObjects.AccordionPage;
import io.cucumber.java.en.Then;

public class StepAccordion {
    AccordionPage accordionPage = new AccordionPage();

    @Then("user choose accordion at section {string}")
    public void user_choose_accordion_at_section(String string) {
        accordionPage.selectAccordion(string);
    }

    @Then("validate text inside accordion at section {string} contains {string} as text")
    public void validate_text_inside_accordion_at_section_contains_as_text(String string, String string2) {
        accordionPage.validateText(string, string2);
    }
}
