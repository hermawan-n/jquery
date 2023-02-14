package StepDefinitions;

import PageObjects.SelectablePage;
import io.cucumber.java.en.Then;

public class StepSelectable {
    SelectablePage selectablePage = new SelectablePage();

    @Then("user choose element on row {string} and column {string} and when element get selected show yellow background color")
    public void user_choose_element_on_row_and_column_and_when_element_get_selected_show_yellow_background_color(
            String string, String string2) throws InterruptedException {
        selectablePage.selectableByRowAndColumn(string, string2);
    }

    @Then("user choose element on row {string} and column {string} until row {string} and column {string}")
    public void user_choose_element_on_row_and_column_until_row_and_column(String string, String string2,
            String string3, String string4) {
        selectablePage.selecableMouse(string, string2, string3, string4);
    }

    @Then("validate if selected elements had orange background")
    public void validate_if_selected_elements_had_orange_background() {
        selectablePage.selectedHadOrangeBG();
    }
}
