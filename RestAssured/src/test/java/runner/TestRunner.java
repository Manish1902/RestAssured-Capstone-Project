package runner;

import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
    features = "src/test/resources/features/todoFeature.feature", 
    glue = "stepDefinations", 
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports/Cucumber.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        BaseTest baseTest = new BaseTest();
        baseTest.setup();
    }
}
