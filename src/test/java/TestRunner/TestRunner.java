package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features", glue = {
        "StepDefinitions" }, tags = "@run", monochrome = false, plugin = { "pretty", "html:target/reports.html" })

public class TestRunner {

}
