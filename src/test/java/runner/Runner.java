package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions
(
	//features="classpath:feature",
	features = "src/test/java/feature",
	glue = {"stepdefination"},
	plugin = {
			"pretty", "html:target/cucumber-reports/Cucumberhtml.html",
			"json:target/cucumber-reports/CucumberTestReport.json",
			"junit:target/cucumber-reports/Cucumber-junit.xml"},
	tags =  "@Smoketest1 or @Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5",
	publish = true,
	monochrome = true	
)
	
public class Runner {

}
