package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="./Feature/login.feature",
glue="")
public class runner {
}
