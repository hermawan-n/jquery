package StepDefinitions;

import PageObjects.ProgressbarPage;
import io.cucumber.java.en.Then;

public class StepProgressbar {
    ProgressbarPage progressbarPage = new ProgressbarPage();

    @Then("user click {string} and download will start")
    public void user_click_and_download_will_start(String string) {
        progressbarPage.chooseButton(string);
    }

    @Then("validate {string} button is displayed at {string}")
    public void validate_button_is_displayed_at(String string, String string2) {
        progressbarPage.validateProgress(string2, string);
    }
}
