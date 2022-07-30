package com.cucumber.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:featurefile/filterSportsfilterOutline.feature" },
		tags = "regressionTesting",
		glue = {"classpath:com.cucumber.framework.stepdefinition" },
		plugin = { "pretty", "json:target/FilterSportsFilterOutlineListValidationFeatureRunner.json" })
public class filterSportsfilterOutlineFeatureRunner extends AbstractTestNGCucumberTests {
}
