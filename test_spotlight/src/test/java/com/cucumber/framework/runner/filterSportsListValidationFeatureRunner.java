package com.cucumber.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:featurefile/filterSportsListValidation.feature" },
		tags = "regressionTesting",
		glue = {"classpath:com.cucumber.framework.stepdefinition" },
		plugin = { "pretty", "json:target/FilterSportsListValidationFeatureRunner.json" })
public class filterSportsListValidationFeatureRunner extends AbstractTestNGCucumberTests {
}
