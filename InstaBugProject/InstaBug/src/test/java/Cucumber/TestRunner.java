package Cucumber;

import BrowserActions.BrowserActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions
        (
                plugin = {
                        "pretty", "html:target/cucumberHtmlReport",
                        "html:target/reports/cucumber/cucumber.html",     //  for html result
                        "json:target/cucumber.json"   // for json result
                },
                features = "src/test/java/Cucumber"
        )

public class TestRunner extends AbstractTestNGCucumberTests {
        @AfterTest
       public void endSession(){
                BrowserActions.quitBrowser();
       }
}