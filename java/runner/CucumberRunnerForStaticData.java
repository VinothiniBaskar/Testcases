package runner;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClassStatic;
@CucumberOptions(features="src/test/java/features",
                 glue="steps",
                 monochrome=true,
                 publish=true
                )
public class CucumberRunnerForStaticData extends BaseClassStatic {

	
}
