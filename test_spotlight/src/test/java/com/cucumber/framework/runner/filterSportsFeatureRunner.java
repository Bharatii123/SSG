package com.cucumber.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:featurefile/filterSports.feature" },
		tags = "regressionTesting",
		glue = {"classpath:com.cucumber.framework.stepdefinition" },
		plugin = { "pretty", "json:target/FilterSportsFeatureRunner.json" })
public class filterSportsFeatureRunner extends AbstractTestNGCucumberTests {
}
