package StepDefinitions;

import PageObjects.ResizablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StepResizable {
    ResizablePage resizablePage = new ResizablePage();

    @Then("user resize the element width as {int} and height as {int}")
    public void user_resize_the_element_width_as_and_height_as(Integer width, Integer height) {
        resizablePage.dragAndDropBy(width, height);
    }

    @And("validate if element height equals {int} and height equals {int}")
    public void validate_if_element_height_equals_and_height_equals(Integer width, Integer height) {
        resizablePage.validateDragAndDropBy(width, height);
    }
}
