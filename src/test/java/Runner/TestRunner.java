package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Shubham Shrivastava\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Evaluation3\\src\\test\\resources\\Ebay\\SearchFunctionality.feature", glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests {

}
