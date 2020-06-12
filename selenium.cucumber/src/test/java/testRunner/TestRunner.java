package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:/Eclipse Workspace/selenium.cucumber/Features/OrangeHRM.feature",
		glue="stepDefinitions"			
		)
public class TestRunner {

}
