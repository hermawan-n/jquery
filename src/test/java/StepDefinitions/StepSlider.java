package StepDefinitions;

import PageObjects.SliderPage;
import io.cucumber.java.en.Then;

public class StepSlider {
    SliderPage sliderPage = new SliderPage();

    @Then("user click slider {string} and slide it until {string} Dollar")
    public void user_click_slider_and_slide_it_until_dollar(String string, String string2) {
        sliderPage.slide(string, string2);
    }
}
