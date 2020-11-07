package day19.suites.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"day19.steps"},
        features = {"src/test/resources/features/fake/FakeTwo.feature"})

public class FakeRunner2 {

}
