package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/java/FeatureFiles/lynkmanager.feature",
					 glue = "StepDefinitions",
					 dryRun = false,
					 monochrome = true,
					 plugin = {"pretty","html:.//Test-Output/Test.html"})

	
public class lynkmanagerRunner {
	
}
