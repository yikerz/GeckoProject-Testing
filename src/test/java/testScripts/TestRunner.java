package testScripts;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features"},
		glue = {"stepDefinitions"},
		tags = "@LogInWithUsernameAndEmptyPassword",
		plugin = {"pretty",
							"html:target/testReports/report.html",
							"json:target/testReports/report.json",
							"junit:target/testReports/report.xml"
							}
		)
public class TestRunner {

}