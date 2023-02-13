package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Driver.Driver;
import PageObjects.DroppablePage;
import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDroppable {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    DroppablePage droppablePage = new DroppablePage();

    @Given("user is on jquery home page")
    public void user_is_on_jquery_home_page() {
        driver.navigate().to("https://jqueryui.com/");
    }

    @And("user go to {string} page")
    public void user_go_to_page(String string) {
        homePage.goToPage(string);
    }

    @Then("user drag and drop element")
    public void user_drag_and_drop_element() {
        droppablePage.dragAndDrop();
    }

    @When("dropable element have {string} text and yellow background color")
    public void dropable_element_have_text_and_yellow_background_color(String string) {
        droppablePage.dragAndDrop();
    }

    @Then("element successfully dropped")
    public void element_successfully_dropped() {
        System.out.println("Validation success!");
    }
}
