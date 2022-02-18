package runner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/java/feature"},
                 tags = "@shopping",
                 glue = {"steps"},
                 plugin = {"pretty", "html:target/cucumber-report.html"},
                 monochrome = true,
                 stepNotifications = true,
                 dryRun = false)

public class Runner {

}
