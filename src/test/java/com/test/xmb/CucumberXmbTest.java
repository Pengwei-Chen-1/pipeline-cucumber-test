package com.test.xmb;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/xmb",
        glue = "com.test.xmb",
        format = {"json:target/cucumber.json"}
)
public class CucumberXmbTest {
}
