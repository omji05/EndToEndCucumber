package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= {"src/test/resources/features/EtoEFLow.feature"},
		glue= {"stepdefinitions","appHooks"},
		plugin = { "timeline:target/timeline_report-cleanup",
        		"pretty","html:target/cucumber-html-report-cleanup",
        		"json:target/cucumber-reports-cleanup/CucumberTestReport.json"},
		monochrome=true,
		dryRun = false
		
		)

public class MyTestRunner extends AbstractTestNGCucumberTests{
	

	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
