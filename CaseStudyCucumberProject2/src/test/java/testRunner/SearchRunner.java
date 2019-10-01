package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features\\Search.feature",
		glue= {"stepDefinition"},
		plugin= {"json:target/cucumber-project/Search.json"}
		)
public class SearchRunner {

}
