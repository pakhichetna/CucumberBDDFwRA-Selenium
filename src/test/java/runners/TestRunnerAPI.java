package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"src/main/java/Features/PizzaOrder.feature"}
		//features = {"C:/Users/ayush01/eclipse-work/WS/w4_04062024/SeleniumKodeTutorial/src/main/java/features/amazon.feature"}
		features = "src/test/java/features/restAssured.feature"
		,glue = {"steps"}
		,publish = true
		,plugin = {"pretty","html:test-output"}
		,monochrome = true
		//,dryRun = false
		)

public class TestRunnerAPI {

}
