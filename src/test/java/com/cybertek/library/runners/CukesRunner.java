package com.cybertek.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features ="src/test/resources/features",
        glue ="com/cybertek/library/step_definitions",
        dryRun = false,
         //  tags = "@wip"
        tags = "@Librarians"
        //tags = "@Students"


)
public class CukesRunner {
}
