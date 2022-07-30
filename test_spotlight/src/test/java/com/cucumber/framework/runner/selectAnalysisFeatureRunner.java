package com.cucumber.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:featurefile/selectFilterSports.feature"},
        tags = "regressionTesting",
        glue = {"classpath:com.cucumber.framework.stepdefinition"},
        plugin = { "pretty", "json:target/selectFilterSportsFeatureRunner.json" })
public class selectAnalysisFeatureRunner extends AbstractTestNGCucumberTests {
}
