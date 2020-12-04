package toolsQA.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "utils.reporter.CustomCucumberPlugin"},
        glue = {"toolsQA.steps"},
        features = {"src/test/resources/features/fake/testQA/TestQA.feature"})
public class SuitRunner {
}
