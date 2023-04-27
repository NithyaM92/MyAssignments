package runner;

import io.cucumber.testng.CucumberOptions;
import step.BaseClass;

@CucumberOptions(features = "src/main/java/feature", glue = "step", monochrome = true, publish = true)
public class CucumberRunner extends BaseClass{

}
