package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "steps",
		tags ="@TF_login2",
		monochrome = true,
		dryRun = false,
		plugin= {
				"pretty",
				"html:target/cucmber",
				"json:target/cucumber.jason"
		}
		
		)
public class LoginRunner {

}
