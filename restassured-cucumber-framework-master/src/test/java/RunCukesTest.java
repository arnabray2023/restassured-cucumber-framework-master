
import org.junit.runner.RunWith;
import cucumber.api.*;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, plugin = { "pretty", "html:target/reports/test-report" }, tags = {
		"@smokeTest" }, dryRun = false, monochrome = true)
public class RunCukesTest {
}
