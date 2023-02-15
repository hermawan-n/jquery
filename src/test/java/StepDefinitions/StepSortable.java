package StepDefinitions;

import PageObjects.SortablePage;
import io.cucumber.java.en.Then;

public class StepSortable {
    SortablePage sortablePage = new SortablePage();

    @Then("user choose item {string} to drop at index {string}")
    public void user_choose_item_to_drop_at_index(String string, String string2) throws InterruptedException {
        sortablePage.clickAndHoldItems(string, string2);
    }

    @Then("validate index {string} contains text item {string}")
    public void validate_index_contains_text_item(String string, String string2) {
        sortablePage.validateOrder(string2, string);
    }
}
