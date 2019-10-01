package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features\\Cart.feature",
		glue= {"stepDefinition"},
		plugin= {"json:target/cucumber-project/CaseStudy.json"}
		)
public class CartRunner {
}
