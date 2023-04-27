package runnerPOM;

import io.cucumber.testng.CucumberOptions;
import pagesPOM.BaseClass;

@CucumberOptions(features = "src/main/java/featurePOM", glue = "pagesPOM", monochrome = true, publish = true)
public class CucumberRunner extends BaseClass{

}
