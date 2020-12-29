package com.cucumber.nowoox;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.cucumber.nowoox"
        , tags = "@Parametrized"
        //, tags = "@Smoke"
        //, tags = "@Sometag"
)
public class CucumberRunnerTest {
}


